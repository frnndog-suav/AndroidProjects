package com.fernandogoia

import model.CurrencyTypeResult
import model.currencyTypes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.ExchangeRateResult
import model.exchangeRates
import model.orUnknown

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

            call.respond(
                ExchangeRateResult(
                    from = from.orUnknown(),
                    to = to.orUnknown(),
                    exchangeRate = exchangeRates[from]?.get(to) ?: 0.0
                )
            )
        }

    }
}
