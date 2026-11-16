package com.example.aplicacionclashroyale

// Representar los datos de una carta
data class Carta(
    val id: Int,
    val nombre: String,
    val rareza: String,
    val elixir: Int,
    val descripcion: String
)
