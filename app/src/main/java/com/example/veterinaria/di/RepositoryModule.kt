package com.example.veterinaria.di

import com.example.veterinaria.data.repository.CalificacionRepositoryImpl
import com.example.veterinaria.data.repository.CarritoRepositoryImpl
import com.example.veterinaria.data.repository.ProductoRepositoryImpl
import com.example.veterinaria.domain.repository.CalificacionRepository
import com.example.veterinaria.domain.repository.CarritoRepository
import com.example.veterinaria.domain.repository.ProductoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductoRepository(impl: ProductoRepositoryImpl): ProductoRepository

    @Binds
    @Singleton
    abstract fun bindCarritoRepository(impl: CarritoRepositoryImpl): CarritoRepository

    @Binds
    @Singleton
    abstract fun bindCalificacionRepository(impl: CalificacionRepositoryImpl): CalificacionRepository
}
