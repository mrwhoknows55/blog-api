package com.mrwhoknows.di

import com.mrwhoknows.config.AppConfig
import com.mrwhoknows.db.DBFactory
import com.mrwhoknows.db.ExposedDBFactory
import com.mrwhoknows.features.articles.data.ArticleLocalDataSource
import com.mrwhoknows.features.articles.data.ArticleLocalDataSourceImpl
import com.mrwhoknows.features.articles.domain.ArticleRepository
import com.mrwhoknows.features.articles.domain.ArticleRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single { AppConfig() }
    single<DBFactory> { ExposedDBFactory(get()) }
    single<ArticleLocalDataSource> { ArticleLocalDataSourceImpl() }
    single<ArticleRepository> { ArticleRepositoryImpl(get()) }
}
