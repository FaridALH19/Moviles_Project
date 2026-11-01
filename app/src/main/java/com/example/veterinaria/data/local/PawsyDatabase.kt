package com.example.veterinaria.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.veterinaria.data.local.dao.CalificacionDao
import com.example.veterinaria.data.local.dao.CarritoDao
import com.example.veterinaria.data.local.dao.ProductoDao
import com.example.veterinaria.data.local.entity.CalificacionEntity
import com.example.veterinaria.data.local.entity.CarritoItemEntity
import com.example.veterinaria.data.local.entity.ProductoEntity

@Database(
    entities = [ProductoEntity::class, CarritoItemEntity::class, CalificacionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PawsyDatabase : RoomDatabase() {
    abstract fun productoDao(): ProductoDao
    abstract fun carritoDao(): CarritoDao
    abstract fun calificacionDao(): CalificacionDao
}
