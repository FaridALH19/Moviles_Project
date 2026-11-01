package com.example.veterinaria.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.veterinaria.data.local.entity.CarritoItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CarritoDao {

    @Query("SELECT * FROM carrito")
    fun observarCarrito(): Flow<List<CarritoItemEntity>>

    @Query("SELECT * FROM carrito WHERE productoId = :productoId LIMIT 1")
    suspend fun obtener(productoId: Int): CarritoItemEntity?

    @Upsert
    suspend fun guardar(item: CarritoItemEntity)
}
