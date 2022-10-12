package com.incubyte.movie;

import java.util.List;

public record TmbdResponse(int page, List<Movie> results) {}
