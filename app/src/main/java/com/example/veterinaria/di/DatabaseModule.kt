package com.example.veterinaria.di

import android.content.Context
import androidx.room.Room
import com.example.veterinaria.data.local.PawsyDatabase
import com.example.veterinaria.data.local.dao.CalificacionDao
import com.example.veterinaria.data.local.dao.CarritoDao
import com.example.veterinaria.data.local.dao.ProductoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): PawsyDatabase =
        Room.databaseBuilder(context, PawsyDatabase::class.java, "pawsy.db").build()

    @Provides
    fun provideProductoDao(db: PawsyDatabase): ProductoDao = db.productoDao()

    @Provides
    fun provideCarritoDao(db: PawsyDatabase): CarritoDao = db.carritoDao()

    @Provides
    fun provideCalificacionDao(db: PawsyDatabase): CalificacionDao = db.calificacionDao()
}
