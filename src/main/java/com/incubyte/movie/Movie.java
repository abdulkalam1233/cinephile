package com.incubyte.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

  private final String name;
  private final String image;
  private final String date;
  private final float rating;
  private final int ratingCount;

  public Movie(
      @JsonProperty("title") String name,
      @JsonProperty("poster_path") String image,
      @JsonProperty("release_date") String date,
      @JsonProperty("vote_average") float rating,
      @JsonProperty("vote_count") int ratingCount) {
    this.name = name;
    this.image = image;
    this.date = date;
    this.rating = rating;
    this.ratingCount = ratingCount;
  }

  public String getName() {
    return name;
  }

  public String getImage() {
    return image;
  }

  public String getDate() {
    return date;
  }

  public float getRating() {
    return rating;
  }

  public int getRatingCount() {
    return ratingCount;
  }
}
