package com.lemon.weather.util;

import com.lemon.weather.entity.objective.CurrentWeatherSummary;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheUtil {
  private static final Logger LOGGER = LoggerFactory.getLogger(CacheUtil.class);

  private static final int TIME_SPAN = 30 * 60 * 1000;

  private Map<String, CurrentWeatherSummary> cacheMap = new ConcurrentHashMap<String, CurrentWeatherSummary>();

  @Autowired
  private OpenWeatherMapClient openWeatherMapClient;

  public CurrentWeatherSummary getCurrentWeatherSummary(String cityName) {
    // save
    CurrentWeatherSummary summary = cacheMap.computeIfAbsent(cityName, (key) -> {
      LOGGER.info("Achieve the forecast weather data from OpenWeatherMap");
      return openWeatherMapClient.showCurrentWeather(key);
    });

    // clean
    if (System.currentTimeMillis() - summary.getCurrentTime() > TIME_SPAN) {
      summary = cacheMap.computeIfPresent(cityName, (key, value) -> {
        LOGGER.info("Retrive the forecast weather data from OpenWeatherMap");
        return openWeatherMapClient.showCurrentWeather(key);
      });
    }

    if (StringUtils.isBlank(summary.getCityName())) {
      cacheMap.remove(cityName);
    }

    return summary;
  }
}
