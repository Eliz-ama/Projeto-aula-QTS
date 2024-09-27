package com.example.Nota

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.request.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable

@Serializable
data class Aluno(val nome: String, val notas: List<Double>)

val alunos = mutableListOf(
    Aluno("João", listOf(8.5, 7.0, 9.0)),
    Aluno("Maria", listOf(6.0, 5.5, 8.0)),
    Aluno("Carlos", listOf(9.5, 9.0, 10.0))
)

fun Application.notasAPI() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        // Rota para obter a média das notas de todos os alunos
        get("/alunos/media") {
            val medias = calcularMedia(alunos)
            call.respond(medias)
        }

        // Rota para obter a nota máxima de todos os alunos
        get("/alunos/maxima") {
            val maximas = calcularNotaMaxima(alunos)
            call.respond(maximas)
        }

        // Rota para obter a nota mínima de todos os alunos
        get("/alunos/minima") {
            val minimas = calcularNotaMinima(alunos)
            call.respond(minimas)
        }

        // Rota para listar os alunos aprovados (média mínima de 6.0)
        get("/alunos/aprovados") {
            val aprovados = alunosAprovados(alunos, 6.0)
            call.respond(aprovados)
        }

        // Rota para adicionar um novo aluno
        post("/alunos/adicionar") {
            val novoAluno = call.receive<Aluno>()
            alunos.add(novoAluno)
            call.respondText("Aluno adicionado com sucesso")
        }
    }
}

// Função para calcular a média de notas dos alunos
fun calcularMedia(alunos: List<Aluno>): Map<String, Double> {
    return alunos.associate { aluno ->
        val media = aluno.notas.average()
        aluno.nome to media
    }
}

// Função para calcular a nota máxima de cada aluno
fun calcularNotaMaxima(alunos: List<Aluno>): Map<String, Double> {
    return alunos.associate { aluno ->
        val maxima = aluno.notas.maxOrNull() ?: 0.0
        aluno.nome to maxima
    }
}

// Função para calcular a nota mínima de cada aluno
fun calcularNotaMinima(alunos: List<Aluno>): Map<String, Double> {
    return alunos.associate { aluno ->
        val minima = aluno.notas.minOrNull() ?: 0.0
        aluno.nome to minima
    }
}

// Função para listar os alunos aprovados com base na média
fun alunosAprovados(alunos: List<Aluno>, mediaMinima: Double): List<String> {
    return alunos.filter { aluno ->
        aluno.notas.average() >= mediaMinima
    }.map { it.nome }
}
