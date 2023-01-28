package com.mrwhoknows.di

import com.mrwhoknows.config.AppConfig
import com.mrwhoknows.features.articles.domain.ArticleRepository
import com.mrwhoknows.features.articles.domain.ArticleRepositoryImpl
import org.koin.dsl.module

val appModule = module {
    single { AppConfig() }
    single<ArticleRepository> { ArticleRepositoryImpl() }
}