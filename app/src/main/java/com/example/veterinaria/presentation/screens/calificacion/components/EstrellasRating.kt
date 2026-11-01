package com.example.veterinaria.presentation.screens.calificacion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.ui.theme.AzulSuave
import com.example.veterinaria.ui.theme.NaranjaTexto

@Composable
fun EstrellasRating(
    estrellas: Int,
    texto: String,
    habilitado: Boolean,
    onSeleccionar: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(AzulSuave)
            .padding(vertical = 16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            (1..5).forEach { valor ->
                IconButton(
                    onClick = { onSeleccionar(valor) },
                    enabled = habilitado,
                    modifier = Modifier.size(52.dp)
                ) {
                    Icon(
                        imageVector = if (valor <= estrellas) Icons.Filled.Star else Icons.Outlined.StarOutline,
                        contentDescription = "$valor estrellas",
                        tint = NaranjaTexto,
                        modifier = Modifier.size(42.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = texto, color = NaranjaTexto, fontSize = 15.sp, fontWeight = FontWeight.SemiBold)
    }
}
