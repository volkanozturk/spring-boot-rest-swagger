package com.volkanozturk.swaggerspringboot.api;

import com.volkanozturk.swaggerspringboot.model.Movie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "Movie REST API")
public class MovieController {

  @ApiResponses(
      value = {
          @ApiResponse(code = 403, message = "Forbidden"),
          @ApiResponse(code = 404, message = "Not found"),
          @ApiResponse(code = 500, message = "Server error")
      }
  )
  @ApiOperation(value = "List of Movie")
  @GetMapping({"/", "/movies"})
  public List<Movie> getMovieList() {
    Map<Integer, Movie> movieList = createMovieList();
    return new ArrayList<>(movieList.values());
  }

  @ApiOperation(value = "Display selected Movie")
  @GetMapping({"/movies/{movieId}"})
  public Movie getMovie(@PathVariable Integer movieId) {
    return createMovieList().get(movieId);
  }

  @PostMapping("/movies")
  public List<Movie> addMovie(@RequestBody Movie movieParam) {
    Map<Integer, Movie> movieList = createMovieList();
    movieList.put(3, movieParam);
    return new ArrayList<>(movieList.values());
  }

  private Map<Integer, Movie> createMovieList() {
    Map<Integer, Movie> movieList = new HashMap<>();
    movieList.put(1, new Movie(1, 8.5, "Ring"));
    movieList.put(2, new Movie(2, 9, "The Prestige"));
    return movieList;
  }
}
