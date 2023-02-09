package com.lemon.weather.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Test;

public class TestCacheUtil {
  @Test
  public void testCacheMap() {
    Map<String, Integer> cacheMap = new ConcurrentHashMap<String, Integer>();
    cacheMap.put("johh", 4);
    cacheMap.put("tom", 3);
    cacheMap.put("marry", 5);

    cacheMap.computeIfPresent("marry", (k, v) -> {
      return 6;
    });

    assertEquals(cacheMap.get("marry"), 6);
  }
}
