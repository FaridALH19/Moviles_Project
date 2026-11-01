package com.example.veterinaria.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.veterinaria.data.local.entity.CalificacionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CalificacionDao {

    @Insert
    suspend fun insertar(calificacion: CalificacionEntity): Long

    @Query("SELECT * FROM calificaciones WHERE citaId = :citaId ORDER BY fecha DESC LIMIT 1")
    fun observarPorCita(citaId: Int): Flow<CalificacionEntity?>
}
