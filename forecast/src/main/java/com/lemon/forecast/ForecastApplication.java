package com.lemon.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath: META-INF/spring/bean.xml"})
public class ForecastApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForecastApplication.class, args);
    }
}