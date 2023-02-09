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
    "all"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {
  @JsonProperty("all")
  private long all;

  // No args constructor for use in serialization
  public Clouds() {}

  /**
   * @param all
   */
  public Clouds(long all) {
    this.all = all;
  }

  /**
   * @return the all
   */
  @JsonProperty("all")
  public long getAll() {
    return all;
  }

  /**
   * @param all The all
   */
  @JsonProperty("all")
  public void setAll(Long all) {
    this.all = all;
  }

  public Clouds withAll(Long all) {
    this.all = all;
    return this;
  }

}
