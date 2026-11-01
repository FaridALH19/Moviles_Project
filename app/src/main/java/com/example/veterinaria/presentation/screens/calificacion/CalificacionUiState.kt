package com.example.veterinaria.presentation.screens.calificacion

import com.example.veterinaria.domain.model.AspectoDestacado
import com.example.veterinaria.domain.model.CitaFinalizada

data class CalificacionUiState(
    val cargando: Boolean = true,
    val cita: CitaFinalizada? = null,
    val estrellas: Int = 0,
    val aspectos: Set<AspectoDestacado> = emptySet(),
    val comentario: String = "",
    val enviando: Boolean = false,
    val enviada: Boolean = false,
    val error: String? = null
) {
    // Texto que aparece debajo de las estrellas
    val textoEstrellas: String
        get() = when (estrellas) {
            1 -> "Muy mala experiencia"
            2 -> "Mala experiencia"
            3 -> "Experiencia regular"
            4 -> "¡Buena experiencia!"
            5 -> "¡Excelente experiencia!"
            else -> "Toca una estrella para calificar"
        }
}
