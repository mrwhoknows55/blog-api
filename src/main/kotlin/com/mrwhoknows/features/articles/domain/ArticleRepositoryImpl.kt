package com.mrwhoknows.features.articles.domain

import com.mrwhoknows.features.articles.data.ArticleLocalDataSource
import com.mrwhoknows.features.articles.domain.mapper.toDTO
import com.mrwhoknows.features.articles.domain.model.ArticleDTO
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class ArticleRepositoryImpl(
    private val articleDataSource: ArticleLocalDataSource
) : ArticleRepository {
    override suspend fun getArticles(): List<ArticleDTO> {
        val articles = newSuspendedTransaction {
            val allArticles = articleDataSource.getAllArticles()
            return@newSuspendedTransaction allArticles.map { it.toDTO() }
        }
        return articles
    }
}