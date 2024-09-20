package com.example.Calculadora

// Função de soma
fun sum(a: Double, b: Double): Double = a + b

// Função de subtração
fun subtract(a: Double, b: Double): Double = a - b

// Função de multiplicação
fun multiply(a: Double, b: Double): Double = a * b

// Função de divisão com verificação de divisão por zero
fun divide(a: Double, b: Double): Double {
    return if (b != 0.0) {
        a / b
    } else {
        throw IllegalArgumentException("Divisão por zero não é permitida")
    }
}



