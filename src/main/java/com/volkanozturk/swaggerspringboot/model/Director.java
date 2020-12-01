package com.volkanozturk.swaggerspringboot.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "Director", description = "Director")
public class Director {

  public Director(Integer id, String name, String surname, List<Movie> movieList) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.movieList = movieList;
  }

  @ApiModelProperty(value = "id")
  private Integer id;

  @ApiModelProperty(value = "name")
  private String name;

  @ApiModelProperty(value = "surname")
  private String surname;

  @ApiModelProperty(value = "movieList")
  private List<Movie> movieList = new ArrayList<>();
}
