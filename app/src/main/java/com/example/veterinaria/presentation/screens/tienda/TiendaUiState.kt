package com.example.veterinaria.presentation.screens.tienda

import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.domain.model.OrdenProducto
import com.example.veterinaria.domain.model.Producto

// Filtros que el usuario controla desde la pantalla
data class FiltrosTienda(
    val busqueda: String = "",
    val categoria: CategoriaProducto = CategoriaProducto.TODOS,
    val orden: OrdenProducto = OrdenProducto.RELEVANCIA
)

// Todo lo que la pantalla necesita para dibujarse
data class TiendaUiState(
    val cargando: Boolean = true,
    val filtros: FiltrosTienda = FiltrosTienda(),
    val productos: List<Producto> = emptyList(),
    val cantidadCarrito: Int = 0,
    val totalCarrito: Double = 0.0,
    val mensaje: String? = null
)
