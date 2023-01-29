package com.mrwhoknows.features.articles.data

import com.mrwhoknows.features.articles.data.dao.Article

interface ArticleLocalDataSource {
    fun getAllArticles(): List<Article>
}