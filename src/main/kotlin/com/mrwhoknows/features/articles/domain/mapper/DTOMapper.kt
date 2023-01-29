package com.mrwhoknows.features.articles.domain.mapper

import com.mrwhoknows.features.articles.data.dao.Article
import com.mrwhoknows.features.articles.domain.model.ArticleDTO
import java.time.ZoneOffset

fun Article.toDTO(): ArticleDTO = ArticleDTO(
    id = this.id.value,
    authorName = this.authorName,
    createdAt = this.createdAt.toEpochSecond(ZoneOffset.UTC),
    lastEdited = this.lastEdited.toEpochSecond(ZoneOffset.UTC),
    title = this.authorName,
    body = this.authorName,
    description = this.authorName,
    tags = this.tags.split(",").map { it.trim() },
    viewCount = this.viewCount,
    wordCount = this.wordCount,
    coverImg = this.coverImg,
    slug = this.slug,
    isPublished = this.isPublished
)