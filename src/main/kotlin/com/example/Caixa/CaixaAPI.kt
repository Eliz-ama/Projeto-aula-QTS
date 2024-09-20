package com.example.Caixa

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val contas = mutableListOf<ContaBancaria>()

fun Application.CaixaAPI(){
    routing {
        // Criar uma nova conta
        post("/conta/{numeroConta}") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull() ?: 0
            if (contas.find { it.numeroConta == numeroConta } == null) {
                val conta = ContaBancaria(numeroConta, 0.0)
                contas.add(conta)
                call.respondText("Conta criada com sucesso!")
            } else {
                call.respondText("Conta já existe.")
            }
        }
    }
}
