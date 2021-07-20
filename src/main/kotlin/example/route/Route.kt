package example.route

import example.request.PostRequest
import example.response.PostResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.root() {
    get("/") {
        call.respond(HttpStatusCode.OK, "Hello World")
    }

    post("/") {
        val request = call.receive<PostRequest>()
        call.respond(PostResponse("${request.value} posted"))
    }
}