package com.example.veterinaria.presentation.screens.tienda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.domain.model.OrdenProducto
import com.example.veterinaria.domain.model.Producto
import com.example.veterinaria.presentation.screens.tienda.components.AvisoFarmaciaCard
import com.example.veterinaria.presentation.screens.tienda.components.BannerPrime
import com.example.veterinaria.presentation.screens.tienda.components.BuscadorTienda
import com.example.veterinaria.presentation.screens.tienda.components.CarritoResumenBar
import com.example.veterinaria.presentation.screens.tienda.components.CategoriasRow
import com.example.veterinaria.presentation.screens.tienda.components.EncabezadoProductos
import com.example.veterinaria.presentation.screens.tienda.components.ProductoCard
import com.example.veterinaria.ui.theme.TextoGris

// Pantalla "con estado": obtiene el ViewModel y le pasa los datos al contenido
@Composable
fun TiendaScreen(
    onVerCarrito: () -> Unit,
    viewModel: TiendaViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.mensaje) {
        uiState.mensaje?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.onMensajeMostrado()
        }
    }

    TiendaContent(
        uiState = uiState,
        snackbarHostState = snackbarHostState,
        onBusquedaChange = viewModel::onBusquedaChange,
        onCategoriaSeleccionada = viewModel::onCategoriaSeleccionada,
        onOrdenSeleccionado = viewModel::onOrdenSeleccionado,
        onFavorito = viewModel::onFavorito,
        onAgregar = viewModel::onAgregarAlCarrito,
        onReservar = viewModel::onReservar,
        onVerCarrito = onVerCarrito
    )
}

// Pantalla "sin estado": solo dibuja lo que recibe
@Composable
fun TiendaContent(
    uiState: TiendaUiState,
    snackbarHostState: SnackbarHostState,
    onBusquedaChange: (String) -> Unit,
    onCategoriaSeleccionada: (CategoriaProducto) -> Unit,
    onOrdenSeleccionado: (OrdenProducto) -> Unit,
    onFavorito: (Int) -> Unit,
    onAgregar: (Producto) -> Unit,
    onReservar: (Producto) -> Unit,
    onVerCarrito: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (uiState.cargando) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 110.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    BuscadorTienda(
                        texto = uiState.filtros.busqueda,
                        cantidadCarrito = uiState.cantidadCarrito,
                        onTextoChange = onBusquedaChange,
                        onCarritoClick = onVerCarrito
                    )
                }
                item(span = { GridItemSpan(maxLineSpan) }) { BannerPrime() }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    CategoriasRow(
                        seleccionada = uiState.filtros.categoria,
                        onSeleccionar = onCategoriaSeleccionada
                    )
                }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    EncabezadoProductos(
                        disponibles = uiState.productos.size,
                        ordenActual = uiState.filtros.orden,
                        onOrdenSeleccionado = onOrdenSeleccionado
                    )
                }

                if (uiState.productos.isEmpty()) {
                    item(span = { GridItemSpan(maxLineSpan) }) {
                        Text(
                            text = "No se encontraron productos",
                            color = TextoGris,
                            modifier = Modifier.padding(vertical = 24.dp)
                        )
                    }
                }

                items(uiState.productos, key = { it.id }) { producto ->
                    ProductoCard(
                        producto = producto,
                        onFavorito = { onFavorito(producto.id) },
                        onAgregar = { onAgregar(producto) },
                        onReservar = { onReservar(producto) }
                    )
                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    AvisoFarmaciaCard(modifier = Modifier.padding(top = 4.dp))
                }
            }

            // Barra flotante del carrito (solo si hay productos)
            if (uiState.cantidadCarrito > 0) {
                CarritoResumenBar(
                    cantidad = uiState.cantidadCarrito,
                    total = uiState.totalCarrito,
                    onVerCarrito = onVerCarrito,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        )
    }
}
