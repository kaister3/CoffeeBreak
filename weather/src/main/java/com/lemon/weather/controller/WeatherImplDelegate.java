package com.lemon.weather.controller;

import com.lemon.weather.entity.objective.CurrentWeatherSummary;
import com.lemon.weather.util.CacheUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherImplDelegate {
  @Autowired
  CacheUtil cacheUtil;

  public CurrentWeatherSummary showCurrentWeather(String cityName) {
    String city = StringUtils.isNotBlank(cityName) ? cityName : "shenzhen, cn";
    return cacheUtil.getCurrentWeatherSummary(city);
  }
}
