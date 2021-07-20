package example.route

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.root() {
    get("/") {
        call.respond(HttpStatusCode.OK, "Hello World")
    }
}