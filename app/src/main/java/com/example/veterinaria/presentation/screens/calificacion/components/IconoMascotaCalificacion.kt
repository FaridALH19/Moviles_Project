package com.example.veterinaria.presentation.screens.calificacion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.veterinaria.ui.theme.AzulClaro
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.NaranjaFondo
import com.example.veterinaria.ui.theme.TextoOscuro

// Círculo azul con la huella y una estrellita en la esquina
@Composable
fun IconoMascotaCalificacion() {
    Box {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(100.dp)
                .background(AzulClaro, CircleShape)
        ) {
            Icon(Icons.Filled.Pets, contentDescription = null, tint = AzulPawsy, modifier = Modifier.size(48.dp))
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .offset(x = 6.dp, y = (-4).dp)
                .size(32.dp)
                .background(NaranjaFondo, CircleShape)
        ) {
            Icon(Icons.Outlined.StarOutline, contentDescription = null, tint = TextoOscuro, modifier = Modifier.size(18.dp))
        }
    }
}
