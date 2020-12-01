package com.volkanozturk.swaggerspringboot.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Movie {

  public Movie(Integer id, double imdbPoint, String movieName) {
    this.id = id;
    this.imdbPoint = imdbPoint;
    this.movieName = movieName;
  }

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(notes = "Point of IMDB")
  private double imdbPoint;

  @ApiModelProperty(value = "movieName")
  private String movieName;
}
