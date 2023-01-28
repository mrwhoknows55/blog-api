package com.mrwhoknows.config

import io.ktor.server.application.*
import org.koin.ktor.ext.inject

class AppConfig {
    lateinit var serverConfig: ServerConfig
}

fun Application.setupConfig() {
    val appConfig by inject<AppConfig>()
    val serverObject = environment.config.config("ktor.server")
    val isProd = serverObject.property("isProd").getString().toBoolean()
    appConfig.serverConfig = ServerConfig(isProd)
}

data class ServerConfig(
    val isProd: Boolean
)
