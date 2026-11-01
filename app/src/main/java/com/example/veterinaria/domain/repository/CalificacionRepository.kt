package com.example.veterinaria.domain.repository

import com.example.veterinaria.domain.model.Calificacion
import com.example.veterinaria.domain.model.CitaFinalizada
import kotlinx.coroutines.flow.Flow

interface CalificacionRepository {
    suspend fun obtenerUltimaCitaFinalizada(): CitaFinalizada
    fun observarCalificacion(citaId: Int): Flow<Calificacion?>
    suspend fun guardar(calificacion: Calificacion)
}
