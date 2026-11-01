package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.AzulSuave
import com.example.veterinaria.ui.theme.NaranjaTexto
import com.example.veterinaria.ui.theme.TextoGris
import com.example.veterinaria.ui.theme.TextoOscuro

@Composable
fun BuscadorTienda(
    texto: String,
    cantidadCarrito: Int,
    onTextoChange: (String) -> Unit,
    onCarritoClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = texto,
            onValueChange = onTextoChange,
            placeholder = { Text("Buscar medicamentos, alimentos...", fontSize = 14.sp, maxLines = 1) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextoGris) },
            singleLine = true,
            shape = RoundedCornerShape(28.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = AzulSuave,
                unfocusedContainerColor = AzulSuave,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Botón de filtros
        IconButton(
            onClick = { },
            modifier = Modifier
                .size(46.dp)
                .background(AzulSuave, CircleShape)
        ) {
            Icon(Icons.Default.Tune, contentDescription = "Filtros", tint = TextoOscuro)
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Botón carrito con contador
        Box {
            IconButton(
                onClick = onCarritoClick,
                modifier = Modifier
                    .size(52.dp)
                    .background(AzulPawsy, CircleShape)
            ) {
                Icon(Icons.Outlined.ShoppingBag, contentDescription = "Carrito", tint = Color.White)
            }
            if (cantidadCarrito > 0) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 4.dp, y = (-4).dp)
                        .size(20.dp)
                        .background(NaranjaTexto, CircleShape)
                ) {
                    Text(
                        text = cantidadCarrito.toString(),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
