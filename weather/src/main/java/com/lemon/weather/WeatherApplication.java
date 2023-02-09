package com.lemon.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource(value = { "classpath:META-INF/spring/bean.xml" })
public class WeatherApplication {
  public static void main(String[] args) {
    SpringApplication.run(WeatherApplication.class, args);
  }
}
