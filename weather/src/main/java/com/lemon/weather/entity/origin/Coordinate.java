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
    "lon",
    "lat"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinate {
  @JsonProperty("lon")
  private Double lon;

  @JsonProperty("lat")
  private Double lat;

  public Coordinate() {}

  public Coordinate(Double lon, Double lat) {
    this.lon = lon;
    this.lat = lat;
  }

  @JsonProperty("lon")
  public Double getLon() {
    return lon;
  }

  @JsonProperty("lon")
  public void setLon(Double lon) {
    this.lon = lon;
  }

  @JsonProperty("lat")
  public Double getLat() {
    return lat;
  }

  @JsonProperty("lat")
  public void setLat(Double lat) {
    this.lat = lat;
  }

  public Coordinate withLat(Double lat) {
    this.lat = lat;
    return this;
  }
}
