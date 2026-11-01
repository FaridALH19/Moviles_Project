package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bolt
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.domain.model.InsigniaProducto
import com.example.veterinaria.ui.theme.AzulInsignia
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.MentaFondo
import com.example.veterinaria.ui.theme.MentaTexto
import com.example.veterinaria.ui.theme.NaranjaFondo
import com.example.veterinaria.ui.theme.NaranjaTexto
import com.example.veterinaria.ui.theme.RojoFondo
import com.example.veterinaria.ui.theme.RojoTexto

// Estilo (icono + colores) de cada tipo de insignia
private data class EstiloInsignia(val icono: ImageVector, val fondo: Color, val texto: Color)

private fun InsigniaProducto.estilo(): EstiloInsignia = when (this) {
    InsigniaProducto.REC_VETERINARIO -> EstiloInsignia(Icons.Outlined.Verified, MentaFondo, MentaTexto)
    InsigniaProducto.RECETA -> EstiloInsignia(Icons.AutoMirrored.Outlined.ReceiptLong, RojoFondo, RojoTexto)
    InsigniaProducto.RESISTENTE -> EstiloInsignia(Icons.Outlined.Bolt, NaranjaFondo, NaranjaTexto)
    else -> EstiloInsignia(Icons.Outlined.Spa, AzulInsignia, AzulPawsy)   // PIEL_SENSIBLE
}

@Composable
fun InsigniaChip(insignia: InsigniaProducto) {
    val estilo = insignia.estilo()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(estilo.fondo, RoundedCornerShape(10.dp))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Icon(estilo.icono, contentDescription = null, tint = estilo.texto, modifier = Modifier.size(12.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = insignia.texto, color = estilo.texto, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}
