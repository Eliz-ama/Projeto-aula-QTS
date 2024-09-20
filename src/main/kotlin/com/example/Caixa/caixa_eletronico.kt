package com.example.Caixa

class ContaBancaria(val numeroConta: Int, private var saldo: Double) {
    fun consultarSaldo(): Double {
        return saldo
    }

    fun depositar(valor: Double) {
        if (valor > 0) {
            saldo += valor
        }
    }

    fun sacar(valor: Double) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor
        }
    }
}
