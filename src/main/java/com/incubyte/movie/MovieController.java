package com.incubyte.movie;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import java.util.List;

@Controller("/movies")
public class MovieController {

  private final MovieService service;

  public MovieController(MovieService service) {
    this.service = service;
  }

  @Get("{id}")
  public Movie getById(int id) {
    return service.getById(id);
  }

  @Get
  public List<Movie> find(@QueryValue String query) {
    return service.find(query);
  }
}
