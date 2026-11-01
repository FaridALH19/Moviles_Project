package com.example.veterinaria.data.repository

import com.example.veterinaria.data.local.dao.CarritoDao
import com.example.veterinaria.data.local.entity.CarritoItemEntity
import com.example.veterinaria.data.mapper.toDomain
import com.example.veterinaria.domain.model.CarritoItem
import com.example.veterinaria.domain.repository.CarritoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CarritoRepositoryImpl @Inject constructor(
    private val carritoDao: CarritoDao
) : CarritoRepository {

    override fun observarCarrito(): Flow<List<CarritoItem>> =
        carritoDao.observarCarrito().map { lista -> lista.map { it.toDomain() } }

    override suspend fun agregar(productoId: Int) {
        val actual = carritoDao.obtener(productoId)
        val nuevaCantidad = (actual?.cantidad ?: 0) + 1
        carritoDao.guardar(CarritoItemEntity(productoId = productoId, cantidad = nuevaCantidad))
    }
}
