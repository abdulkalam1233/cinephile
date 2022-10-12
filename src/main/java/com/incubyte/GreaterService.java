package com.incubyte;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;

public class GreaterService {

  @Inject
  @Client("https://jsonplaceholder.typicode.com/users/")
  HttpClient client;

  public Response greet(String id) {
    Person person = client.toBlocking().retrieve("/" + id, Person.class);
    return new Response(person.name(), "Hello");
  }
}
