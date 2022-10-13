package com.incubyte.movie;

import io.micronaut.context.annotation.Bean;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

@Bean
public class MovieGateWay {

  @Inject
  @Client("https://api.themoviedb.org/3")
  HttpClient httpClient;

  public TmbdResponse find(String query) {
    return httpClient
        .toBlocking()
        .retrieve(
            HttpRequest.GET(
                "/search/movie?api_key=e470560acfb347655d8af373c29aba11&query=" + query),
            TmbdResponse.class);
  }

  public Movie getById(int id) {
    return httpClient
        .toBlocking()
        .retrieve(
            HttpRequest.GET("/movie/" + id + "?api_key=e470560acfb347655d8af373c29aba11"),
            Movie.class);
  }
}
