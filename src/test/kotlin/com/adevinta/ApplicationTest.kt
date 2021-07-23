package com.adevinta

import com.adevinta.infra.route.configureMovieRouting
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureMovieRouting()}) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello, Movie World!", response.content)
            }
        }
    }
}