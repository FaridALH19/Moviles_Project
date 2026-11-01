package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.AzulSuave
import com.example.veterinaria.ui.theme.TextoGris
import com.example.veterinaria.ui.theme.TextoOscuro

@Composable
fun AvisoFarmaciaCard(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(AzulSuave, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Icon(Icons.Outlined.Info, contentDescription = null, tint = AzulPawsy, modifier = Modifier.size(22.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text("Farmacia Segura Pawsy", color = TextoOscuro, fontWeight = FontWeight.Medium, fontSize = 15.sp)
            Text(
                text = "Los fármacos marcados con receta médica serán validados automáticamente " +
                    "con la ficha clínica digital de tu mascota al finalizar la compra.",
                color = TextoGris,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        }
    }
}
