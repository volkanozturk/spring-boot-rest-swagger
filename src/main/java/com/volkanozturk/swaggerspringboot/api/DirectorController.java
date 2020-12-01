package com.volkanozturk.swaggerspringboot.api;

import com.volkanozturk.swaggerspringboot.model.Director;
import com.volkanozturk.swaggerspringboot.model.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DirectorController {

  @GetMapping({"/directors/{directorId}"})
  public Director getDirector(@PathVariable Integer directorId) {

    return createDirectorList().get(directorId);
  }

  @DeleteMapping("/directors/{movieId}")
  public List<Director> deleteDirector(@PathVariable Integer directorId) {
    Map<Integer, Director> directorList = createDirectorList();
    directorList.remove(directorId);
    return new ArrayList<>(directorList.values());
  }

  @PutMapping("/directors/{directorId}")
  public Director updateDirector(@PathVariable Integer directorId, @RequestBody Director directorParam) {
    Map<Integer, Director> personList = createDirectorList();
    return personList.replace(directorId, directorParam);
  }

  private Map<Integer, Director> createDirectorList() {
    Map<Integer, Director> personList = new HashMap<>();
    personList.put(1, new Director(1, "Stanley", "Kubrick", getMovieList(1)));
    personList.put(1, new Director(2, "David", "Lynch", getMovieList(2)));

    return personList;
  }

  private List<Movie> getMovieList(int directorId) {
    List<Movie> movieList = new ArrayList<>();
    if (directorId == 1) {
      movieList.add(new Movie(1, 9, "Blabla Blabla"));
      movieList.add(new Movie(2, 8, "Full Metal Jacket"));
    } else {
      movieList.add(new Movie(1, 7, "Inland Empire"));
      movieList.add(new Movie(2, 7.5, "Hollyshorts Greeting"));
    }
    return movieList;
  }
}

