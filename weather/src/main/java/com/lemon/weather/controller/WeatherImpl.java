package com.lemon.weather.controller;

import com.lemon.weather.entity.objective.CurrentWeatherSummary;
import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:26:36.166+08:00")

@RestController
@RequestMapping(path = "/weather", produces = MediaType.APPLICATION_JSON_VALUE)
public class WeatherImpl {
  private static final Logger LOGGER = LoggerFactory.getLogger(WeatherImpl.class);

  @Autowired
  private WeatherImplDelegate userCurrentWeatherDataDelegate;

  private int latencyTime = 0;

  @PostConstruct
  public void init() {
    LOGGER.info("Init success");
    DynamicIntProperty latency = DynamicPropertyFactory.getInstance().getIntProperty("latncy", 0);
    latency.addCallback(() -> {
      latencyTime = latency.get();
      LOGGER.info("Latency time changed to {}", latencyTime);
    });
    latencyTime = latency.get();
  }

  @GetMapping(value = "/show", produces = MediaType.APPLICATION_JSON_VALUE)
  public CurrentWeatherSummary showCurrentWeatherSummary(@RequestParam(value = "city") String city, @RequestParam(value = "user", required = false) String user) {
    if (latencyTime > 0) {
      try {
        Thread.sleep(latencyTime);
      } catch (Exception e) {

      }
    }
    LOGGER.info("showCurrentWeather() is called, city = [{}], user = [{}]", city, user);
    return userCurrentWeatherDataDelegate.showCurrentWeather(city);
  }
}
