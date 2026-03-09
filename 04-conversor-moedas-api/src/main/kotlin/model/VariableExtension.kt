package model

fun String.orUnknown(): String {
    if (this in exchangeRates.keys) {
        return this
    } else {
        return "Desconhecido"
    }
}