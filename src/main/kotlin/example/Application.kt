package example

import io.ktor.routing.routing
import example.route.root
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*
import io.ktor.locations.*
import io.netty.handler.codec.DefaultHeaders

fun main(args: Array<String>) {
    // Nettyを使うための初期設定
    io.ktor.server.netty.EngineMain.main(args)
}

@KtorExperimentalLocationsAPI
@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    // module() 関数内 で install() を 実行 することで Ktor に 様々 な module を 追加 することが 可能 です。
    install(DefaultHeaders)
    install(Locations)
    install(CallLogging)
    install(ContentNegotiation) {
        // json形式のPostを受け取るためのライブラリ
        jackson {  }
    }

    routing {
        root()
    }
}
