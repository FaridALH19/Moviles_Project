package com.example.veterinaria.domain.repository

import com.example.veterinaria.domain.model.CarritoItem
import kotlinx.coroutines.flow.Flow

interface CarritoRepository {
    fun observarCarrito(): Flow<List<CarritoItem>>
    suspend fun agregar(productoId: Int)
}
