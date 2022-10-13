package com.incubyte.movie;

import jakarta.inject.Singleton;
import java.util.Collections;
import java.util.List;

@Singleton
public class MovieService {

  private final MovieGateWay movieGateWay;

  public MovieService(MovieGateWay movieGateWay) {

    this.movieGateWay = movieGateWay;
  }

  public List<Movie> find(String movie) {
    TmbdResponse tmbdResponse = movieGateWay.find(movie);
    return tmbdResponse == null ? Collections.emptyList() : tmbdResponse.results();
  }

  public Movie getById(int id) {
    return movieGateWay.getById(id);
  }
}
