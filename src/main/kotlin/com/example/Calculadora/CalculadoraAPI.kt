package com.example.Calculadora

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing


fun Application.CalculadoraAPI() {
    routing {

        // Rota inicial
        get("/") {
            call.respondText("Bem-vindo ao Sistema de Caixa e Calculadora!")
        }

        // Rotas da Calculadora
        get("/sum/{a}/{b}") {
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0
            call.respondText(sum(a, b).toString())
        }

        get("/subtract/{a}/{b}") {
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0
            call.respondText(subtract(a, b).toString())
        }

        get("/multiply/{a}/{b}") {
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0
            call.respondText(multiply(a, b).toString())
        }

        get("/divide/{a}/{b}") {
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 1.0
            if (b == 0.0) {
                call.respondText("Erro: Divisão por zero não permitida.")
            } else {
                call.respondText(divide(a, b).toString())
            }
        }
    }
}