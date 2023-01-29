package com.mrwhoknows.config

import io.ktor.server.application.*
import org.koin.ktor.ext.inject

class AppConfig {
    lateinit var dbConfig: DatabaseConfig
    lateinit var serverConfig: ServerConfig
}

fun Application.setupConfig() {
    val appConfig by inject<AppConfig>()

    val serverObject = environment.config.config("ktor.server")
    val isProd = serverObject.property("isProd").getString().toBoolean()
    appConfig.serverConfig = ServerConfig(isProd)

    val databaseObject = environment.config.config("ktor.database")
    val driverClass = databaseObject.property("driverClass").getString()
    val url = databaseObject.property("url").getString()
    val user = databaseObject.property("user").getString()
    val password = databaseObject.property("password").getString()
    val maxPoolSize = databaseObject.property("maxPoolSize").getString().toInt()
    appConfig.dbConfig = DatabaseConfig(driverClass, url, user, password, maxPoolSize)
}

data class ServerConfig(
    val isProd: Boolean
)
data class DatabaseConfig(
    val driverClass: String,
    val url: String,
    val user: String,
    val password: String,
    val maxPoolSize: Int
)