package michibaum.com.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import michibaum.com.db.*
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.entity.*
import java.io.File

data class UserDto(var name: String)
fun toUserDto(row: QueryRowSet) = UserDto(row[Users.name].orEmpty())

fun Application.configureRouting(database: Database) {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/favicon.ico") {
            call.apply {
                response.header(
                    HttpHeaders.ContentDisposition,
                    ContentDisposition.Attachment.withParameter(ContentDisposition.Parameters.FileName, "favicon.ico")
                        .toString()
                )
                File("src/main/resources/favicon.ico").also {
                    respondFile(it)
                }
            }
        }
        get("/users"){
            call.respond(
                database
                    .from(Users)
                    .select(Users.name)
                    .map(::toUserDto)
                    .also(::println)
            )
        }
    }
}

