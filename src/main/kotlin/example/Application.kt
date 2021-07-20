package example

import io.ktor.routing.routing
import example.route.root
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.netty.handler.codec.DefaultHeaders

fun main(args: Array<String>) {
    // Nettyを使うための初期設定
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    install(DefaultHeaders)
    install(ContentNegotiation) {
        jackson {  }
    }
    routing {
        root()
    }
}
