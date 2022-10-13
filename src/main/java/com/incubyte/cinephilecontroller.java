package com.incubyte;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/cinephile")
public class cinephilecontroller {

  @Inject GreaterService greaterService;

  @Get(uri = "/people/{id}", produces = "application/json")
  public Response index(@Parameter() String id) {
    return greaterService.greet(id);
  }

  @Post(uri = "/people/{id}", produces = "application/json")
  public Response add(@Parameter() String id) {
    return greaterService.greet(id);
  }
}
