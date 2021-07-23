package com.adevinta.app

import com.adevinta.domain.movies.DefaultMovieService
import com.adevinta.infra.adapter.ApiMovieAdapter
import com.adevinta.infra.route.configureMovieRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import org.kodein.di.bind
import org.kodein.di.ktor.di
import org.kodein.di.singleton

fun main() {

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {

        di {
            val movieService = DefaultMovieService()
            bind<ApiMovieAdapter>() with singleton { ApiMovieAdapter(movieService) }
        }

        configureHTTP()
        configureMovieRouting()
    }.start(wait = true)
}

fun Application.configureHTTP() {
    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("MyCustomHeader")
        allowCredentials = true
        anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
}
