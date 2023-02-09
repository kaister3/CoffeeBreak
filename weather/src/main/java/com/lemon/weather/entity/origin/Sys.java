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
    "type",
    "id",
    "message",
    "country",
    "sunrise",
    "sunset"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {
  @JsonProperty("type")
  private Long type;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("message")
  private Double message;

  @JsonProperty("country")
  private String country;

  @JsonProperty("sunrise")
  private Long sunrise;

  @JsonProperty("sunset")
  private Long sunset;

  public Sys() {}

  public Sys(Long type, Long id, Double message, String country, Long sunrise, Long sunset) {
    this.type = type;
    this.id = id;
    this.message = message;
    this.country = country;
    this.sunrise = sunrise;
    this.sunset = sunset;
  }

  @JsonProperty("type")
  public Long getType() {
    return type;
  }

  @JsonProperty("type")
  public void setType(Long type) {
    this.type = type;
  }

  public Sys withType(Long type) {
    this.type = type;
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


  public Sys withId(Long id) {
    this.id = id;
    return this;
  }

  @JsonProperty("message")
  public Double getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(Double message) {
    this.message = message;
  }

  public Sys withMessage(Double message) {
    this.message = message;
    return this;
  }

  @JsonProperty("country")
  public String getCountry() {
    return country;
  }

  @JsonProperty("country")
  public void setCountry(String country) {
    this.country = country;
  }

  public Sys withCountry(String country) {
    this.country = country;
    return this;
  }

  @JsonProperty("sunrise")
  public Long getSunrise() {
    return sunrise;
  }

  @JsonProperty("sunrise")
  public void setSunrise(Long sunrise) {
    this.sunrise = sunrise;
  }

  public Sys withSunrise(Long sunrise) {
    this.sunrise = sunrise;
    return this;
  }

  @JsonProperty("sunset")
  public Long getSunset() {
    return sunset;
  }

  @JsonProperty("sunset")
  public void setSunset(Long sunset) {
    this.sunset = sunset;
  }

  public Sys withSunset(Long sunset) {
    this.sunset = sunset;
    return  this;
  }
}
