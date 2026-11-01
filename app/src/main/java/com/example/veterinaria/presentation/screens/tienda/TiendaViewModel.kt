package com.example.veterinaria.presentation.screens.tienda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.domain.model.OrdenProducto
import com.example.veterinaria.domain.model.Producto
import com.example.veterinaria.domain.repository.CarritoRepository
import com.example.veterinaria.domain.repository.ProductoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TiendaViewModel @Inject constructor(
    private val productoRepository: ProductoRepository,
    private val carritoRepository: CarritoRepository
) : ViewModel() {

    private val filtros = MutableStateFlow(FiltrosTienda())
    private val mensaje = MutableStateFlow<String?>(null)

    val uiState: StateFlow<TiendaUiState> = combine(
        productoRepository.observarProductos(),
        carritoRepository.observarCarrito(),
        filtros,
        mensaje
    ) { productos, carrito, filtrosActuales, mensajeActual ->
        val preciosPorId = productos.associate { it.id to it.precio }
        TiendaUiState(
            cargando = false,
            filtros = filtrosActuales,
            productos = aplicarFiltros(productos, filtrosActuales),
            cantidadCarrito = carrito.sumOf { it.cantidad },
            totalCarrito = carrito.sumOf { (preciosPorId[it.productoId] ?: 0.0) * it.cantidad },
            mensaje = mensajeActual
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = TiendaUiState()
    )

    init {
        viewModelScope.launch { productoRepository.cargarDatosIniciales() }
    }

    // ----- Eventos que llegan desde la UI -----

    fun onBusquedaChange(texto: String) = filtros.update { it.copy(busqueda = texto) }

    fun onCategoriaSeleccionada(categoria: CategoriaProducto) =
        filtros.update { it.copy(categoria = categoria) }

    fun onOrdenSeleccionado(orden: OrdenProducto) = filtros.update { it.copy(orden = orden) }

    fun onFavorito(productoId: Int) {
        viewModelScope.launch { productoRepository.alternarFavorito(productoId) }
    }

    fun onAgregarAlCarrito(producto: Producto) {
        viewModelScope.launch {
            carritoRepository.agregar(producto.id)
            mensaje.value = "${producto.nombre} añadido al carrito"
        }
    }

    fun onReservar(producto: Producto) {
        viewModelScope.launch {
            productoRepository.reservar(producto.id)
            mensaje.value = "Reserva registrada. Se validará la receta de tu mascota."
        }
    }

    fun onMensajeMostrado() {
        mensaje.value = null
    }

    // ----- Lógica de filtrado / ordenamiento -----

    private fun aplicarFiltros(productos: List<Producto>, f: FiltrosTienda): List<Producto> {
        val texto = f.busqueda.trim()
        val filtrados = productos.filter { p ->
            val coincideCategoria = f.categoria == CategoriaProducto.TODOS || p.categoria == f.categoria
            val coincideTexto = texto.isEmpty() ||
                p.nombre.contains(texto, ignoreCase = true) ||
                p.etiqueta.contains(texto, ignoreCase = true) ||
                p.descripcion.contains(texto, ignoreCase = true)
            coincideCategoria && coincideTexto
        }
        return when (f.orden) {
            OrdenProducto.MENOR_PRECIO -> filtrados.sortedBy { it.precio }
            OrdenProducto.MAYOR_PRECIO -> filtrados.sortedByDescending { it.precio }
            else -> filtrados   // RELEVANCIA: orden original
        }
    }
}
