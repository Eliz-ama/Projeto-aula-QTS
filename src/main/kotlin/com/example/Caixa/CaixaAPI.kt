package com.example.Caixa

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// Lista de contas bancárias simulada
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

        // Consultar saldo
        get("/conta/{numeroConta}/saldo") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull()
            val conta = contas.find { it.numeroConta == numeroConta }
            if (conta != null) {
                call.respondText("Saldo atual: R$${conta.consultarSaldo()}")
            } else {
                call.respondText("Conta não encontrada.")
            }
        }

        // Depositar na conta
        post("/conta/{numeroConta}/depositar/{valor}") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull()
            val valor = call.parameters["valor"]?.toDoubleOrNull()

            val conta = contas.find { it.numeroConta == numeroConta }
            if (conta != null && valor != null) {
                conta.depositar(valor)
                call.respondText("Depósito de R$$valor realizado com sucesso. Saldo atual: R$${conta.consultarSaldo()}")
            } else {
                call.respondText("Erro ao processar depósito.")
            }
        }

        // Sacar da conta
        post("/conta/{numeroConta}/sacar/{valor}") {
            val numeroConta = call.parameters["numeroConta"]?.toIntOrNull()
            val valor = call.parameters["valor"]?.toDoubleOrNull()

            val conta = contas.find { it.numeroConta == numeroConta }
            if (conta != null && valor != null) {
                val resultadoSaque = conta.sacar(valor)
                if (resultadoSaque > 0) {
                    call.respondText("Saque de R$$valor realizado com sucesso. Saldo atual: R$${conta.consultarSaldo()}")
                } else {
                    call.respondText("Saldo insuficiente para saque.")
                }
            } else {
                call.respondText("Erro ao processar saque.")
            }
        }
    }
}
