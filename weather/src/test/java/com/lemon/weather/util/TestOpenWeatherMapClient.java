package com.lemon.weather.util;

import org.junit.jupiter.api.Test;

public class TestOpenWeatherMapClient {
  @Test
  public void testRandomDouble() {
    OpenWeatherMapClient client = new OpenWeatherMapClient();
    double a = client.randomDouble(12.3, 10, 5);
    System.out.println(a);
  }
}
