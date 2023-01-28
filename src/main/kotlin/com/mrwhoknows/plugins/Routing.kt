package com.mrwhoknows.plugins

import com.mrwhoknows.features.articles.resource.articleEndpoint
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.locations.*

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.configureRouting() {
    install(Locations)
    routing {
        route("/api/v1"){
            route("/article") {
                articleEndpoint()
            }
        }

        get("/") {
            call.respondText("Hello World!")
        }
    }
}
