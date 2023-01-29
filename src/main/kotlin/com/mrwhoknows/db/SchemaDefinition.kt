package com.mrwhoknows.db

import com.mrwhoknows.features.articles.data.dao.ArticleTable
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object SchemaDefinition {
    fun createSchema(): Unit = transaction {
        SchemaUtils.create(ArticleTable)
    }
}