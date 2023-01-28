package com.mrwhoknows.features.articles.resource

import com.mrwhoknows.features.articles.domain.ArticleRepository
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
class ArticleEndpoint {

    @Location("/all")
    class All
}

@KtorExperimentalLocationsAPI
fun Route.articleEndpoint() {
    val articleRepository by inject<ArticleRepository>()

    get<ArticleEndpoint.All> {
        call.respond(articleRepository.getArticles())
    }
}