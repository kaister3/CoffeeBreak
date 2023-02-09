package com.lemon.weather.entity.origin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.Generated;

@JsonInclude(Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "temp",
    "feels_like",
    "temp_min",
    "temp_max",
    "pressure",
    "humidity",
    "sea_level",
    "grnd_level"

})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
  @JsonProperty("temp")
  private Double temp;

  @JsonProperty("feels_like")
  private Double feelsLike;

  @JsonProperty("pressure")
  private Long pressure;

  @JsonProperty("humidity")
  private Long humidity;

  @JsonProperty("temp_min")
  private Double tempMin;

  @JsonProperty("temp_max")
  private Double tempMax;

  @JsonProperty("sea_level")
  private int seaLevel;

  @JsonProperty("grnd_level")
  private int grndLevel;

  public Main() {}

  public Main(Double temp, Long pressure, Long humidity, Double tempMin, Double tempMax) {
    this.temp = temp;
    this.pressure = pressure;
    this.humidity = humidity;
    this.tempMin = tempMin;
    this.tempMax = tempMax;
  }

  @JsonProperty("temp")
  public Double getTemp() {
    return temp;
  }

  @JsonProperty("temp")
  public void setTemp(Double temp) {
    this.temp = temp;
  }

  public Main withTemp(Double temp) {
    this.temp = temp;
    return this;
  }

  @JsonProperty("pressure")
  public Long getPressure() {
    return pressure;
  }

  @JsonProperty("pressure")
  public void setPressure(Long pressure) {
    this.pressure = pressure;
  }

  public Main withPressure(Long pressure) {
    this.pressure = pressure;
    return this;
  }

  @JsonProperty("humidity")
  public Long getHumidity() {
    return humidity;
  }

  @JsonProperty("humidity")
  public void setHumidity(Long humidity) {
    this.humidity = humidity;
  }

  public Main withHumidity(Long humidity) {
    this.humidity = humidity;
    return this;
  }

  @JsonProperty("temp_min")
  public Double getTempMin() {
    return tempMin;
  }

  @JsonProperty("temp_min")
  public void setTempMin(Double tempMin) {
    this.tempMin = tempMin;
  }

  public Main withTempMin(Double tempMin) {
    this.tempMin = tempMin;
    return this;
  }

  @JsonProperty("temp_max")
  public Double getTempMax() {
    return tempMax;
  }

  @JsonProperty("temp_max")
  public void setTempMax(Double tempMax) {
    this.tempMax = tempMax;
  }

  public Main withTempMax(Double tempMax) {
    this.tempMax = tempMax;
    return this;
  }

  @JsonProperty("feels_like")
  public Double getFeelsLike() {
    return feelsLike;
  }

  @JsonProperty("feels_like")
  public void setFeelsLike(Double feelsLike) {
    this.feelsLike = feelsLike;
  }

  @JsonProperty("sea_level")
  public int getSeaLevel() {
    return seaLevel;
  }

  @JsonProperty("sea_level")
  public void setSeaLevel(int seaLevel) {
    this.seaLevel = seaLevel;
  }

  @JsonProperty("grnd_level")
  public int getGrndLevel() {
    return grndLevel;
  }

  @JsonProperty("grnd_level")
  public void setGrndLevel(int grndLevel) {
    this.grndLevel = grndLevel;
  }
}
