package com.example.veterinaria.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.EditCalendar
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val ruta: String, val titulo: String, val icono: ImageVector) {
    object Inicio : BottomNavItem(RutasNav.INICIO, "Inicio", Icons.Outlined.Home)
    object Mascotas : BottomNavItem(RutasNav.MASCOTAS, "Mis Mascotas", Icons.Filled.Pets)
    object Agendar : BottomNavItem(RutasNav.AGENDAR, "Agendar", Icons.Outlined.EditCalendar)
    object Tienda : BottomNavItem(RutasNav.TIENDA, "Tienda", Icons.Outlined.ShoppingBag)
    object Historial : BottomNavItem(RutasNav.HISTORIAL, "Historial", Icons.Outlined.Description)
}
