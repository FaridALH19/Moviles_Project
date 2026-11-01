package com.example.veterinaria.domain.model

data class CitaFinalizada(
    val id: Int,
    val mascota: String,
    val veterinario: String,
    val horaFin: String,
    val clinica: String
)
