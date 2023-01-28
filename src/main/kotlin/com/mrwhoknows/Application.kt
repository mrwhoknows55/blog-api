package com.mrwhoknows

import ch.qos.logback.classic.Logger
import com.mrwhoknows.config.AppConfig
import com.mrwhoknows.config.setupConfig
import com.mrwhoknows.di.appModule
import com.mrwhoknows.plugins.*
import io.ktor.server.application.*
import org.koin.core.module.Module
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import org.slf4j.LoggerFactory

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
@JvmOverloads
fun Application.module(
    testing: Boolean = false, koinModules: List<Module> = listOf(appModule)
) {
    install(Koin) {
        slf4jLogger()
        modules(koinModules)
    }
    setupConfig()
    val appConfig by inject<AppConfig>()

    if (!appConfig.serverConfig.isProd) {
        val root = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME) as Logger
        root.level = ch.qos.logback.classic.Level.TRACE
    }

    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureSecurity()
    configureRouting()
}
