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
    "speed",
    "deg",
    "gust"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
  @JsonProperty("speed")
  private Double speed;

  @JsonProperty("deg")
  private Double deg;

  @JsonProperty("gust")
  private Double gust;

  public Wind() {}

  public Wind(Double speed, Double deg) {
    this.speed = speed;
    this.deg = deg;
  }

  @JsonProperty("speed")
  public Double getSpeed() {
    return speed;
  }

  @JsonProperty("speed")
  public void setSpeed(Double speed) {
    this.speed = speed;
  }

  public Wind withSpeed(Double speed) {
    this.speed = speed;
    return this;
  }

  @JsonProperty("deg")
  public Double getDeg() {
    return deg;
  }

  @JsonProperty("deg")
  public void setDeg(Double deg) {
    this.deg = deg;
  }

  public Wind withDeg(Double deg) {
    this.deg = deg;
    return this;
  }

  public Double getGust() {
    return gust;
  }

  public void setGust(Double gust) {
    this.gust = gust;
  }
}
