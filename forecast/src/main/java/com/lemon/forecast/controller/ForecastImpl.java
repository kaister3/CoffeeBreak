package com.lemon.forecast.controller;

import com.netflix.config.DynamicIntProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.lemon.forecast.entity.objective.ForecastSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

//@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2017-11-01T10:16:52.801+08:00")

@RestController
@RequestMapping(path = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
public class ForecastImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ForecastImpl.class);

    @Autowired
    private ForecastImplDelegate userForecastweatherdataDelegate;

    private int latencyTime = 0;

    @PostConstruct
    public void init() {
        LOGGER.info("Init success");
        DynamicIntProperty latency = DynamicPropertyFactory.getInstance().getIntProperty("latency", 0);
        latency.addCallback(() -> {
            latencyTime = latency.get();
            LOGGER.info("Latency time change to {}", latencyTime);
        });
        latencyTime = latency.get();
    }

    @RequestMapping(value = "/show",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ForecastSummary getForecast(@RequestParam(value = "city", required = true) String city) {
        LOGGER.info("getForecast() is called, city = [{}]", city);
        if (latencyTime > 0) {
            try {
                Thread.sleep(latencyTime);
            } catch (Exception e) {

            }
        }
        return userForecastweatherdataDelegate.showForecastWeather(city);
    }
}
