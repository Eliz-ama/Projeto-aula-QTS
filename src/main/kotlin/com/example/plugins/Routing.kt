package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.Caixa.CaixaAPI
import com.example.Caixa.ContaBancaria
import com.example.Calculadora.*


// Lista de contas bancárias simulada (em memória)
val contas = mutableListOf<ContaBancaria>()

fun Application.configureRouting() {
    CaixaAPI()
    CalculadoraAPI()
}

    // Função para formatar os números como string
    fun Double.formatDoubleToString(): String {
        return "%.2f".format(this)
    }
