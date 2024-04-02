package com.nombre.laboratoiro2

interface ContadorListener{
    fun incrementar()
    fun getValorActual(): Int
    fun resetar()
    fun reducir()
}