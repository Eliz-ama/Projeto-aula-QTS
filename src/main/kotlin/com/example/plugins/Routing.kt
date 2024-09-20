package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.Calculadora.sum

fun Application.configureRouting() {
    routing {

        get("/") {
            call.respondText("Calculadora API!")
        }
        get("/sum/{a}/{b}"){
            val a = call.parameters["a"]?.toDoubleOrNull() ?: 0.0
            val b = call.parameters["b"]?.toDoubleOrNull() ?: 0.0
            call.respondText(sum(a,b).toString())
        }
    }
}
fun formatParameters(number:Double):String{
    return number?.toDouble().toString()
}
fun Double.formatDoubleToString():String{
    return this.toString()
}