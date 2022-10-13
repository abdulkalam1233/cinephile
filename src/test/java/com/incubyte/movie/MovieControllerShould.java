package com.incubyte.movie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MovieControllerShould {

  @Mock MovieService service;

  @Test
  @DisplayName("should invoke service find method")
  void should_invoke_service_find_method() {
    MovieController movieController = new MovieController(service);
    movieController.find("Maverick");
    Mockito.verify(service).find("Maverick");
  }

  @Test
  @DisplayName("should invoke service find get movie details method")
  void should_invoke_service_find_get_movie_details_method() {
    MovieController movieController = new MovieController(service);
    movieController.getById(123);
    Mockito.verify(service).getById(123);
  }
}
