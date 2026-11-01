package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.domain.model.OrdenProducto
import com.example.veterinaria.ui.theme.AzulClaro
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.TextoGris
import com.example.veterinaria.ui.theme.TextoOscuro

@Composable
fun EncabezadoProductos(
    disponibles: Int,
    ordenActual: OrdenProducto,
    onOrdenSeleccionado: (OrdenProducto) -> Unit
) {
    var menuAbierto by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Productos Destacados",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextoOscuro,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "$disponibles disponibles",
            fontSize = 11.sp,
            color = AzulPawsy,
            modifier = Modifier
                .background(AzulClaro, RoundedCornerShape(12.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Menú "Ordenar por"
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { menuAbierto = true }
            ) {
                Column {
                    Text("Ordenar por", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = TextoOscuro)
                    Text(ordenActual.titulo, fontSize = 10.sp, color = TextoGris)
                }
                Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = TextoGris)
            }
            DropdownMenu(expanded = menuAbierto, onDismissRequest = { menuAbierto = false }) {
                OrdenProducto.lista.forEach { orden ->
                    DropdownMenuItem(
                        text = { Text(orden.titulo) },
                        onClick = {
                            onOrdenSeleccionado(orden)
                            menuAbierto = false
                        }
                    )
                }
            }
        }
    }
}
