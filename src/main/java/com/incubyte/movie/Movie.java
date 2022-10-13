package com.incubyte.movie;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

  private final String name;
  private final String image;
  private final String date;
  private final float rating;
  private final int ratingCount;
  private final int id;
  private final String backDrop;
  private final int duration;
  private final String description;
  private final int revenue;
  private final String language;

  public Movie(
      @JsonProperty("title") String name,
      @JsonProperty("poster_path") String image,
      @JsonProperty("release_date") String date,
      @JsonProperty("vote_average") float rating,
      @JsonProperty("vote_count") int ratingCount,
      @JsonProperty("id") int id,
      @JsonProperty("runtime") int duration,
      @JsonProperty("overview") String description,
      @JsonProperty("revenue") int revenue,
      @JsonProperty("original_language") String language,
      @JsonProperty("backdrop_path") String backDrop) {
    this.name = name;
    this.image = image;
    this.date = date;
    this.rating = rating;
    this.ratingCount = ratingCount;
    this.id = id;
    this.duration = duration;
    this.description = description;
    this.revenue = revenue;
    this.language = language;
    this.backDrop = backDrop;
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

  public int getDuration() {
    return duration;
  }

  public String getDescription() {
    return description;
  }

  public int getRevenue() {
    return revenue;
  }

  public String getLanguage() {
    return language;
  }

  public String getBackDrop() {
    return backDrop;
  }

  public int getId() {
    return id;
  }
}
