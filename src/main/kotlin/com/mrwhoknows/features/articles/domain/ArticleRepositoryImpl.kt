package com.mrwhoknows.features.articles.domain

import com.mrwhoknows.features.articles.domain.model.ArticleDTO
import java.util.UUID

class ArticleRepositoryImpl : ArticleRepository {
    override suspend fun getArticles(): List<ArticleDTO> = listOf(
        ArticleDTO(
            id = UUID.randomUUID().toString(),
            authorName = "author",
            body = "lorem ipsum body",
            createdAt = System.currentTimeMillis(),
            lastEdited = System.currentTimeMillis(),
            title = "Title: ${System.currentTimeMillis()}",
            description = "description lorem ipsum",
            tags = listOf("tag1", "tag2"),
            viewCount = 20,
            wordCount = 100,
            coverImg = "",
            slug = "test-slug-1",
            isPublished = true
        )
    )
}