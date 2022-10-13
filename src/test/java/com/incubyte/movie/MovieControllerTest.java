package com.incubyte.movie;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
class MovieControllerTest {

  @Inject
  @Client("/movies")
  HttpClient httpClient;

  @Test
  @DisplayName("Search movies for given movie name")
  void should_search_movies_for_given_movie_name() {
    List<Movie> movies =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.GET("?query=maverick"), Argument.listOf(Movie.class));
    assertThat(movies.size()).isPositive();
    assertThat(movies.get(0).getName()).isEqualTo("Top Gun: Maverick");
    assertThat(movies.get(0).getImage()).isEqualTo("/62HCnUTziyWcpDaBO2i1DX17ljH.jpg");
    assertThat(movies.get(0).getDate()).isEqualTo("2022-05-24");
    assertThat(movies.get(0).getRating()).isEqualTo(8.4f);
    assertThat(movies.get(0).getRatingCount()).isPositive();
    assertThat(movies.get(0).getId()).isEqualTo(361743);
  }

  @Test
  @DisplayName("Get movie details by id")
  void get_movie_details_by_id() {
    Movie movie = httpClient.toBlocking().retrieve(HttpRequest.GET("/361743"), Movie.class);
    assertThat(movie.getName()).isEqualTo("Top Gun: Maverick");
    assertThat(movie.getImage()).isEqualTo("/62HCnUTziyWcpDaBO2i1DX17ljH.jpg");
    assertThat(movie.getDate()).isEqualTo("2022-05-24");
    assertThat(movie.getRating()).isEqualTo(8.357f);
    assertThat(movie.getRatingCount()).isPositive();
    assertThat(movie.getDuration()).isPositive();
    assertThat(movie.getDescription().length()).isGreaterThan(0);
    assertThat(movie.getRevenue()).isPositive();
    assertThat(movie.getLanguage()).isEqualTo("en");
    assertThat(movie.getBackDrop()).isEqualTo("/odJ4hx6g6vBt4lBWKFD1tI8WS4x.jpg");
    assertThat(movie.getId()).isEqualTo(361743);
  }
}
