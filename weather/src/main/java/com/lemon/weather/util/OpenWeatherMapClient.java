package com.lemon.weather.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lemon.weather.entity.objective.CurrentWeatherSummary;
import com.lemon.weather.entity.origin.WeatherData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherMapClient {
  private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapClient.class);

  private static final Random random = new Random();

  private static final String APP_KEY = "763d8bb819e1b0fb58c8385ddd26856e";

  private static final String DEFAULT = "ShenZhen,CN";

  // Metric: Celsius, Imperial: Fahrenheit
  private static String URL_HTTPS = "https://api.openweathermap.org/data/2.5/weather?appid=%s&q=%s&units=metric";

  private static String URL_HTTP = "http://api.openweathermap.org/data/2.5/weather?appid=%s&q=%s&units=metric";

  private static String URL = URL_HTTP;

  private static WeatherData MOCK_WEATHER_DATA = null;

  static {
    //  mock data
    try {
      ClassPathResource resource = new ClassPathResource("mock/weather.json");
      InputStream inputStream = resource.getInputStream();
      String data = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(
          Collectors.joining(System.lineSeparator()));
      ObjectMapper mapper = new ObjectMapper();
      MOCK_WEATHER_DATA = mapper.readValue(data, WeatherData.class);
    } catch (IOException e) {
      LOGGER.error("Failed to load mock data.", e);
    }
  }

  @Value("${mock.enabled}")
  private boolean mockEnabled;

  @Autowired
  @Qualifier("restProxyTemplate")
  private RestTemplate restTemplate;

  /**
   * switch url between http and https
   */
  private void switchUrl() {
    if (URL.equals(URL_HTTP)) {
      URL = URL_HTTPS;
    } else {
      URL = URL_HTTP;
    }

    LOGGER.info("switch URL");
  }

  /**
   * return random double
   * @param v
   * @param m
   * @param n
   * @return
   */
  public Double randomDouble(double v, int m, int n) {
    return Double.valueOf(String.format("%.2f", v + Math.floor(random.nextDouble() * m - n)));
  }

  public CurrentWeatherSummary showCurrentWeather(String city) {
    city = StringUtils.isNotBlank(city) ? city : DEFAULT;

    CurrentWeatherSummary summary = new CurrentWeatherSummary();
    try {
      WeatherData weatherData;

      if (mockEnabled) {
        weatherData = MOCK_WEATHER_DATA;

        summary.setCityName(city);
        summary.setCountry(MOCK_WEATHER_DATA.getSys().getCountry());
        summary.setTemperature(randomDouble(weatherData.getMain().getTemp(), 10, 5));
        summary.setWindSpeed(randomDouble(weatherData.getWind().getSpeed(), 2, 1));
        summary.setPressure(randomDouble(weatherData.getMain().getPressure(), 100, 50));
        summary.setHumidity(randomDouble(weatherData.getMain().getHumidity(), 30, 15));
      } else {
        // get weather data from OpenWeatherMap
        LOGGER.info(String.format(URL, APP_KEY, city));
        weatherData = restTemplate.getForObject(String.format(URL, APP_KEY, city), WeatherData.class);

        LOGGER.info(weatherData.toString());

        summary.setCityName(weatherData.getName());
        summary.setCountry(weatherData.getSys().getCountry());
        summary.setTemperature(weatherData.getMain().getTemp());
        summary.setWindSpeed(weatherData.getWind().getSpeed());
        summary.setPressure(weatherData.getMain().getPressure());
        summary.setHumidity(weatherData.getMain().getHumidity());
      }
      summary.setImage(weatherData.getWeather().get(0).getIcon());
      summary.setDate(weatherData.getDt());
      summary.setWeather(weatherData.getWeather().get(0).getDescription());
      summary.setCloudiness(weatherData.getWeather().get(0).getDescription());
      summary.setCloudsDeg(weatherData.getClouds().getAll());
      summary.setSunrise(weatherData.getSys().getSunrise());
      summary.setSunset(weatherData.getSys().getSunset());
      summary.setCoordinatesLon(weatherData.getCoordinate().getLon());
      summary.setCoordinatesLat(weatherData.getCoordinate().getLat());
    } catch (Exception e) {
      LOGGER.info("Failed to get current weather data from OpenWeatherMap with " + city, e);

      switchUrl();
    }

    return summary;
  }
}
