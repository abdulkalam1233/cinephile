package com.incubyte;

public class Response {
  private final String name;
  private final String message;

  Response(String name, String message) {
    this.name = name;
    this.message = message;
  }

  public String getName() {
    return name;
  }

  public String getMessage() {
    return message;
  }
}
