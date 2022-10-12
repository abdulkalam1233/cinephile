package com.incubyte.movie;

import java.util.List;
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
    List<Movie> movies = movieController.find("Maverick");
    Mockito.verify(service).find("Maverick");
  }
}
