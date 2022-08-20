package michibaum.com

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import michibaum.com.plugins.*
import org.ktorm.database.Database

fun main() {

    val database = Database.connect("jdbc:mysql://localhost:3306/jazz", driver = "com.mysql.cj.jdbc.Driver", user = "root", password = "root")

    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureMonitoring()
        configureSerialization()
        configureRouting(database)
    }.start(wait = true)

}
