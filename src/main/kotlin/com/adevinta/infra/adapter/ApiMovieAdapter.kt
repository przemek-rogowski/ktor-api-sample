package com.adevinta.infra.adapter

import com.adevinta.domain.movies.MovieService
import com.google.gson.Gson

class ApiMovieAdapter(val movieService: MovieService) {

    var gson = Gson()

    fun getMovies(): String {
        return gson.toJson(movieService.getMovies())
    }
}