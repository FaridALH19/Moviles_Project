package com.example.veterinaria.domain.model

data class Calificacion(
    val id: Int = 0,
    val citaId: Int,
    val estrellas: Int,                       // 1 a 5
    val aspectos: Set<AspectoDestacado>,
    val comentario: String,
    val fecha: Long = System.currentTimeMillis()
)
