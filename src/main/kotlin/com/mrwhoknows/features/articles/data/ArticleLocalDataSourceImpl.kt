package com.mrwhoknows.features.articles.data

import com.mrwhoknows.features.articles.data.dao.Article
import com.mrwhoknows.features.articles.data.dao.ArticleTable
import org.jetbrains.exposed.sql.selectAll

class ArticleLocalDataSourceImpl : ArticleLocalDataSource {
    override fun getAllArticles(): List<Article> = Article.wrapRows(ArticleTable.selectAll()).toList()
}