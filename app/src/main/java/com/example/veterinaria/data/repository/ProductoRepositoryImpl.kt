package com.example.veterinaria.data.repository

import com.example.veterinaria.data.local.DatosIniciales
import com.example.veterinaria.data.local.dao.ProductoDao
import com.example.veterinaria.data.mapper.toDomain
import com.example.veterinaria.domain.model.Producto
import com.example.veterinaria.domain.repository.ProductoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductoRepositoryImpl @Inject constructor(
    private val productoDao: ProductoDao
) : ProductoRepository {

    override fun observarProductos(): Flow<List<Producto>> =
        productoDao.observarProductos().map { lista -> lista.map { it.toDomain() } }

    override suspend fun cargarDatosIniciales() {
        if (productoDao.contar() == 0) {
            productoDao.insertarTodos(DatosIniciales.productos)
        }
    }

    override suspend fun alternarFavorito(productoId: Int) =
        productoDao.alternarFavorito(productoId)

    override suspend fun reservar(productoId: Int) =
        productoDao.marcarReservado(productoId)
}
