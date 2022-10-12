package com.incubyte.movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieServiceShould {

  @Mock MovieGateWay movieGateWay;

  @Test
  @DisplayName("should invoke the gateway find method")
  void should_invoke_the_gateway_find_method() {
    // Given
    MovieService movieService = new MovieService(movieGateWay);

    // when
    movieService.find("Maverick");

    // then
    Mockito.verify(movieGateWay).find("Maverick");
  }

  @Test
  @DisplayName("Should return the movies list")
  void should_return_the_movies_list() {
    // given
    List<Movie> moviesData =
        List.of(new Movie("TopGun: Maverick", "image", "2022-05-05", 8.1f, 10000));
    TmbdResponse tmdbResponse = new TmbdResponse(1, moviesData);
    Mockito.when(movieGateWay.find("Maverick")).thenReturn(tmdbResponse);
    MovieService movieService = new MovieService(movieGateWay);

    // when
    List<Movie> movies = movieService.find("Maverick");

    // then
    Mockito.verify(movieGateWay).find("Maverick");
    assertThat(movies).hasSize(1);
    Movie movie = movies.get(0);
    assertThat(movie.getName()).isEqualTo("TopGun: Maverick");
    assertThat(movie.getImage()).isEqualTo("image");
    assertThat(movie.getDate()).isEqualTo("2022-05-05");
    assertThat(movie.getRating()).isEqualTo(8.1f);
    assertThat(movie.getRatingCount()).isEqualTo(10000);
  }
}
