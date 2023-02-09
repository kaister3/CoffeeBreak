package com.lemon.weather.entity.origin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@JsonInclude(Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "timezone",
    "id",
    "name",
    "cod"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
  @JsonProperty("coord")
  private Coordinate coordinate;

  @JsonProperty("weather")
  private List<Weather> weather = new ArrayList<Weather>();

  @JsonProperty("base")
  private String base;

  @JsonProperty("main")
  private Main main;

  @JsonProperty("visibility")
  private int visibility;

  @JsonProperty("wind")
  private Wind wind;

  @JsonProperty("clouds")
  private Clouds clouds;

  @JsonProperty("dt")
  private Long dt;

  @JsonProperty("sys")
  private Sys sys;

  @JsonProperty("timezone")
  private Long timezone;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("cod")
  private Long cod;

  public WeatherData(){}

  public WeatherData(Coordinate coordinate,
      List<Weather> weather, String base, Main main, int visibility, Wind wind, Clouds clouds, Long dt, Sys sys, Long timezone, Long id, String name, Long cod) {
    this.coordinate = coordinate;
    this.weather = weather;
    this.base = base;
    this.main = main;
    this.visibility = visibility;
    this.wind = wind;
    this.clouds = clouds;
    this.dt = dt;
    this.sys = sys;
    this.timezone = timezone;
    this.id = id;
    this.name = name;
    this.cod = cod;
  }

  @JsonProperty("coordinate")
  public Coordinate getCoordinate() {
    return coordinate;
  }

  @JsonProperty("coordinate")
  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
  }

  public WeatherData withCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
    return this;
  }

  @JsonProperty("weather")
  public List<Weather> getWeather() {
    return weather;
  }

  @JsonProperty("weather")
  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  public WeatherData withWeather(List<Weather> Weather) {
    this.weather = weather;
    return this;
  }

  @JsonProperty("base")
  public String getBase() {
    return base;
  }

  @JsonProperty("base")
  public void setBase(String base) {
    this.base = base;
  }

  public WeatherData withBase(String base) {
    this.base = base;
    return this;
  }

  @JsonProperty("main")
  public Main getMain() {
    return main;
  }

  @JsonProperty("main")
  public void setMain(Main main) {
    this.main = main;
  }

  public WeatherData withMain(Main main) {
    this.main = main;
    return this;
  }

  @JsonProperty("visibility")
  public int getVisibility() {
    return visibility;
  }

  @JsonProperty("visibility")
  public void setVisibility(int visibility) {
    this.visibility = visibility;
  }

  public WeatherData withVisibility(int visibility) {
    this.visibility = visibility;
    return this;
  }

  @JsonProperty("wind")
  public Wind getWind() {
    return wind;
  }

  @JsonProperty("wind")
  public void setWind(Wind wind) {
    this.wind = wind;
  }

  public WeatherData witthWind(Wind wind) {
    this.wind = wind;
    return this;
  }

  @JsonProperty("clouds")
  public Clouds getClouds() {
    return clouds;
  }

  @JsonProperty("clouds")
  public void setClouds(Clouds clouds) {
    this.clouds = clouds;
  }

  @JsonProperty("dt")
  public Long getDt() {
    return dt;
  }

  @JsonProperty("dt")
  public void setDt(Long dt) {
    this.dt = dt;
  }

  public WeatherData withDt(Long dt) {
    this.dt = dt;
    return this;
  }

  @JsonProperty("sys")
  public Sys getSys() {
    return sys;
  }

  @JsonProperty("sys")
  public void setSys(Sys sys) {
    this.sys = sys;
  }

  public WeatherData withSys(Sys sys) {
    this.sys = sys;
    return this;
  }

  @JsonProperty("timezone")
  public Long GetTimezone() {
    return timezone;
  }

  @JsonProperty("timezone")
  public void setTimezone(Long timezone) {
    this.timezone = timezone;
  }

  public WeatherData withTimezone(Long timezone) {
    this.timezone = timezone;
    return this;
  }

  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Long id) {
    this.id = id;
  }

  public WeatherData withId(Long id) {
    this.id = id;
    return this;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  public WeatherData withName(String name) {
    this.name = name;
    return this;
  }

  @JsonProperty("cod")
  public Long getCod() {
    return cod;
  }

  @JsonProperty("cod")
  public void setCod(Long cod) {
    this.cod = cod;
  }

  public WeatherData withCod(Long cod) {
    this.cod = cod;
    return this;
  }
}
