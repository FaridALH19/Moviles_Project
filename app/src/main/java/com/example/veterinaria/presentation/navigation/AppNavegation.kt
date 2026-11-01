package com.example.veterinaria.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.veterinaria.presentation.screens.calificacion.CalificacionScreen
import com.example.veterinaria.presentation.screens.construccion.EnConstruccionScreen
import com.example.veterinaria.presentation.screens.tienda.TiendaScreen

@Composable
fun AppNavegation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = RutasNav.TIENDA
    ) {
        composable(RutasNav.TIENDA) {
            TiendaScreen(
                onVerCarrito = { navHostController.navigate(RutasNav.CARRITO) }
            )
        }
        composable(RutasNav.HISTORIAL) {
            CalificacionScreen()
        }
        // Pantallas que aún no forman parte de esta entrega
        composable(RutasNav.INICIO) { EnConstruccionScreen("Inicio") }
        composable(RutasNav.MASCOTAS) { EnConstruccionScreen("Mis Mascotas") }
        composable(RutasNav.AGENDAR) { EnConstruccionScreen("Agendar") }
        composable(RutasNav.CARRITO) { EnConstruccionScreen("Carrito de compras") }
    }
}
