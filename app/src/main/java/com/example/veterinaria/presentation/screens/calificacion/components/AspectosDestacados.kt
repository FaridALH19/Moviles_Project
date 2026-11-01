package com.example.veterinaria.presentation.screens.calificacion.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.domain.model.AspectoDestacado
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.AzulSuave
import com.example.veterinaria.ui.theme.TextoGris
import com.example.veterinaria.ui.theme.TextoOscuro

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AspectosDestacados(
    seleccionados: Set<AspectoDestacado>,
    habilitado: Boolean,
    onClick: (AspectoDestacado) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("¿Qué fue lo más destacable?", color = TextoGris, fontSize = 13.sp)
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            AspectoDestacado.lista.forEach { aspecto ->
                val activo = aspecto in seleccionados
                FilterChip(
                    selected = activo,
                    enabled = habilitado,
                    onClick = { onClick(aspecto) },
                    label = { Text(aspecto.texto, fontWeight = FontWeight.SemiBold, fontSize = 13.sp) },
                    shape = RoundedCornerShape(20.dp),
                    border = null,
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = AzulSuave,
                        labelColor = TextoOscuro,
                        selectedContainerColor = AzulPawsy,
                        selectedLabelColor = Color.White,
                        disabledContainerColor = AzulSuave,
                        disabledLabelColor = TextoOscuro,
                        disabledSelectedContainerColor = AzulPawsy
                    )
                )
            }
        }
    }
}
