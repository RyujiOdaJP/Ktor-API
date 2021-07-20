package example

import io.ktor.routing.routing
import example.route.root
import io.ktor.application.Application

fun main(args: Array<String>) {
    // Nettyを使うための初期設定
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    routing {
        root()
    }
}
