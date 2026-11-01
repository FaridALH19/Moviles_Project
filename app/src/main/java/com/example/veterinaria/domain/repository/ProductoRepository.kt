package com.example.veterinaria.domain.repository

import com.example.veterinaria.domain.model.Producto
import kotlinx.coroutines.flow.Flow

interface ProductoRepository {
    fun observarProductos(): Flow<List<Producto>>
    suspend fun cargarDatosIniciales()
    suspend fun alternarFavorito(productoId: Int)
    suspend fun reservar(productoId: Int)
}
