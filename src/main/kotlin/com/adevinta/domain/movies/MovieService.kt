package com.adevinta.domain.movies

data class Movie(val name: String)

interface MovieService {

    fun getMovies(): List<Movie>
}

class DefaultMovieService : MovieService {

    override fun getMovies(): List<Movie> {
        return listOf(
            Movie("Alien"),
            Movie("Jurassic Park"),
            Movie("Star Wars"),
            Movie("Willow"),
            Movie("Matrix"),
            Movie("Brave heart"),
        )
    }

}