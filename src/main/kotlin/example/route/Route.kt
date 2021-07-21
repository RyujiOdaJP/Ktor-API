package example.route

import example.request.PostRequest
import example.response.PostResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

@KtorExperimentalLocationsAPI
fun Routing.root() {
    get("/") {
        call.respond(HttpStatusCode.OK, "Hello World")
    }

    //  Locations を 使用 すると API の path parameter を タイプセーフ に 扱 うことが 可能 です。
    @KtorExperimentalLocationsAPI
    @Location("/{id}")
    data class IdParam(
        val id: Int
    )
    get<IdParam> {
        call.respond(it.id)
    }

    post("/") {
        val request = call.receive<PostRequest>()
        call.respond(HttpStatusCode.OK, PostResponse("${request.value} posted"))
    }


}