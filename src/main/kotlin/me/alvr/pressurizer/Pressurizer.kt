package me.alvr.pressurizer

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.Compression
import io.ktor.features.DefaultHeaders
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.sessions.Sessions

fun Application.pressurizer() {
    install(CallLogging)
    install(Compression)
    install(DefaultHeaders)
    install(CORS)
    install(Sessions)
}

fun main(args: Array<String>) {
    embeddedServer(
        Netty,
        module = Application::pressurizer,
        host = "localhost"
    ).start(wait = true)
}