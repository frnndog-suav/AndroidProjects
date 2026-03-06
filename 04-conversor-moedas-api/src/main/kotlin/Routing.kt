package com.fernandogoia

import CurrencyTypeResult
import currencyTypes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/currency_types") {
            call.respond(
                CurrencyTypeResult(
                    values = currencyTypes
                )
            )
        }

        get("/exchange_rate/{from}/{to}") {
            val from = call.parameters["from"]?.uppercase() ?: return@get call.respondText(
                status = HttpStatusCode.BadRequest,
                text = "Não foi possível obter o acrônimo da moeda atual."
            )
            val to = call.parameters["to"]?.uppercase() ?: return@get call.respondText(
                status = HttpStatusCode.BadRequest,
                text = "Não foi possível obter o acrônimo da moeda atual."
            )


        }


    }
}
