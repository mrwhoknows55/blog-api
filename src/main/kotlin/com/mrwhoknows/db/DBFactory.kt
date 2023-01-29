package com.mrwhoknows.db

interface DBFactory {
    fun connect()
    fun close()
}