package com.example.veterinaria.data.repository

import com.example.veterinaria.data.local.DatosIniciales
import com.example.veterinaria.data.local.dao.CalificacionDao
import com.example.veterinaria.data.mapper.toDomain
import com.example.veterinaria.data.mapper.toEntity
import com.example.veterinaria.domain.model.Calificacion
import com.example.veterinaria.domain.model.CitaFinalizada
import com.example.veterinaria.domain.repository.CalificacionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CalificacionRepositoryImpl @Inject constructor(
    private val calificacionDao: CalificacionDao
) : CalificacionRepository {

    override suspend fun obtenerUltimaCitaFinalizada(): CitaFinalizada = DatosIniciales.ultimaCita

    override fun observarCalificacion(citaId: Int): Flow<Calificacion?> =
        calificacionDao.observarPorCita(citaId).map { it?.toDomain() }

    override suspend fun guardar(calificacion: Calificacion) {
        calificacionDao.insertar(calificacion.toEntity())
    }
}
