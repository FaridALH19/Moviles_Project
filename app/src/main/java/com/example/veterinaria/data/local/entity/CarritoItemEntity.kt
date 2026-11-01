package com.example.veterinaria.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carrito")
data class CarritoItemEntity(
    @PrimaryKey val productoId: Int,
    val cantidad: Int
)
