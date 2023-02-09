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
    "1h"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {
  @JsonProperty("1h")
  private Double _1h;

  public Rain() {}

  public Rain(Double _1h) {
    this._1h = _1h;
  }

  @JsonProperty("1h")
  public Double get_1h() {
    return _1h;
  }

  @JsonProperty("1h")
  public void set_1h(Double _1h) {
    this._1h = _1h;
  }

  public Rain with1h(Double _1h) {
    this._1h = _1h;
    return this;
  }
}
