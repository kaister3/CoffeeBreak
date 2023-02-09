package com.lemon.weather.util;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
  private static final Logger LOGGER = LoggerFactory.getLogger(RestConfiguration.class);

  @Value("${proxy.enabled}")
  private boolean proxyEnabled = false;

  @Value("${proxy.host}")
  private String proxyHost;

  @Value("${proxy.port}")
  private int proxyPort;

  @Value("${proxy.user}")
  private String proxyUser;

  @Value("${proxy.password}")
  private String proxyPassword;

  @Value("${rest.readtimeout}")
  private int restReadtimeout;

  @Value("${rest.connecttimeout}")
  private int restConnectionTimeout;

  @Bean
  public HttpComponentsClientHttpRequestFactory httpClientFactory() {
    HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();

    httpRequestFactory.setConnectTimeout(restConnectionTimeout);
    httpRequestFactory.setReadTimeout(restReadtimeout);

    if (proxyEnabled) {
      CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
      credentialsProvider.setCredentials(new AuthScope(proxyHost, proxyPort), new UsernamePasswordCredentials(proxyUser, proxyPassword));

      HttpClient httpclient = HttpClientBuilder.create().setProxy(new HttpHost(proxyHost, proxyPort)).setDefaultCredentialsProvider(credentialsProvider).disableCookieManagement().build();
      httpRequestFactory.setHttpClient(httpclient);

      LOGGER.info("http proxy enabled");
    }

    return httpRequestFactory;
  }

  @Bean
  @Qualifier("restProxyTemplate")
  public RestTemplate restProxyTemplate(HttpComponentsClientHttpRequestFactory httpClientFactory) {
    return new RestTemplate(httpClientFactory);
  }

  @Bean
  public RestTemplate testTemplate() {
    return null;
  }
}
