package com.mrwhoknows.features.articles.domain

import com.mrwhoknows.features.articles.domain.model.ArticleDTO

interface ArticleRepository {
    suspend fun getArticles(): List<ArticleDTO>
}