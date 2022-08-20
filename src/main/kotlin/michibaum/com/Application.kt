package michibaum.com

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import michibaum.com.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureMonitoring()
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}
