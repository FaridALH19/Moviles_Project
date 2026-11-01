package com.example.veterinaria.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calificaciones")
data class CalificacionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val citaId: Int,
    val estrellas: Int,
    val aspectos: String,         // nombres de AspectoDestacado separados por coma
    val comentario: String,
    val fecha: Long
)
