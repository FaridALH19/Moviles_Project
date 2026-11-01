package com.example.veterinaria.presentation.common

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.veterinaria.presentation.navigation.BottomNavItem
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.TextoOscuro

@Composable
fun AppBottomBar(navHostController: NavHostController) {
    val opciones = listOf(
        BottomNavItem.Inicio,
        BottomNavItem.Mascotas,
        BottomNavItem.Agendar,
        BottomNavItem.Tienda,
        BottomNavItem.Historial
    )

    NavigationBar(containerColor = Color.White) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val rutaActual = navBackStackEntry?.destination?.route

        opciones.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icono, contentDescription = item.titulo) },
                label = {
                    Text(
                        text = item.titulo,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        maxLines = 2
                    )
                },
                selected = rutaActual == item.ruta,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AzulPawsy,
                    selectedTextColor = AzulPawsy,
                    unselectedIconColor = TextoOscuro,
                    unselectedTextColor = TextoOscuro,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navHostController.navigate(item.ruta) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
