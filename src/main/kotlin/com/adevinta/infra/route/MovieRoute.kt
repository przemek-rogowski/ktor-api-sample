package com.adevinta.infra.route

import com.adevinta.infra.adapter.ApiMovieAdapter
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.kodein.di.instance
import org.kodein.di.ktor.di

fun Application.configureMovieRouting() {
    routing {

        val apiMovieAdapter by di().instance<ApiMovieAdapter>()

        get("/movies") {
            call.respondText(apiMovieAdapter.getMovies())
        }

        get("/") {
            call.respondText("Hello, Movie World!")
        }
    }
}