package com.mrwhoknows.features.articles.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDTO(
    val id: String,
    val authorName: String,
    val createdAt: Long,
    val lastEdited: Long,
    val title: String,
    val body: String,
    val description: String,
    val tags: List<String>,
    val viewCount: Long,
    val wordCount: Long,
    val coverImg: String,
    val slug: String,
    val isPublished: Boolean
)