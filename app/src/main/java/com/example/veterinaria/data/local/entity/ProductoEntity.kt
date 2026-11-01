package com.example.veterinaria.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productos")
data class ProductoEntity(
    @PrimaryKey val id: Int,
    val nombre: String,
    val descripcion: String,
    val categoria: String,        // id de CategoriaProducto (ej: "ALIMENTOS")
    val etiqueta: String,
    val insignia: String?,        // id de InsigniaProducto (ej: "RECETA")
    val precio: Double,
    val precioAnterior: Double?,
    val imagen: String,
    val requiereReceta: Boolean,
    val esFavorito: Boolean = false,
    val reservado: Boolean = false
)
