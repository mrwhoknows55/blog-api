package com.mrwhoknows.features.articles.data.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.javatime.datetime

object ArticleTable : IdTable<String>(name = "article") {
    val createdAt = datetime("createdAt")
    val lastEdited = datetime("lastEdited")
    val authorName = varchar("authorName", 255)
    val title = text("title")
    val body = text("body")
    val description = text("description")
    val tags = text("tags")
    val viewCount = long("viewCount")
    val wordCount = long("wordCount")
    val coverImg = text("coverImg")
    val slug = varchar("slug", 128)
    val isPublished = bool("isPublished")
    override val id: Column<EntityID<String>> = varchar("id", 255).entityId()
    override val primaryKey = PrimaryKey(id)
}

class Article(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, Article>(ArticleTable)
    val createdAt by ArticleTable.createdAt
    val lastEdited by ArticleTable.lastEdited
    val authorName by ArticleTable.authorName
    val title by ArticleTable.title
    val body by ArticleTable.body
    val description by ArticleTable.description
    val tags by ArticleTable.tags
    val viewCount by ArticleTable.viewCount
    val wordCount by ArticleTable.wordCount
    val coverImg by ArticleTable.coverImg
    val slug by ArticleTable.slug
    val isPublished by ArticleTable.isPublished
}