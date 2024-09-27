package com.example.notas

data class Aluno(val nome: String, val notas: List<Double>)

fun calcularMedia(alunos: List<Aluno>): Map<String, Double> {
    return alunos.associate { aluno ->
        val media = aluno.notas.average()
        aluno.nome to media
    }
}

fun calcularNotaMaxima(alunos: List<Aluno>): Map<String, Double> {
    return alunos.associate { aluno ->
        val maxima = aluno.notas.maxOrNull() ?: 0.0
        aluno.nome to maxima
    }
}

fun calcularNotaMinima(alunos: List<Aluno>): Map<String, Double> {
    return alunos.associate { aluno ->
        val minima = aluno.notas.minOrNull() ?: 0.0
        aluno.nome to minima
    }
}

fun alunosAprovados(alunos: List<Aluno>, mediaMinima: Double): List<String> {
    return alunos.filter { aluno ->
        aluno.notas.average() >= mediaMinima
    }.map { it.nome }
}
