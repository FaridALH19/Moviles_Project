package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.outlined.Medication
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Soap
import androidx.compose.material.icons.outlined.SportsBaseball
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.AzulSuave
import com.example.veterinaria.ui.theme.TextoOscuro

private fun CategoriaProducto.icono(): ImageVector = when (this) {
    CategoriaProducto.ALIMENTOS -> Icons.Outlined.Restaurant
    CategoriaProducto.FARMACIA -> Icons.Outlined.Medication
    CategoriaProducto.JUGUETES -> Icons.Outlined.SportsBaseball
    CategoriaProducto.HIGIENE -> Icons.Outlined.Soap
    else -> Icons.Filled.GridView
}

@Composable
fun CategoriasRow(
    seleccionada: CategoriaProducto,
    onSeleccionar: (CategoriaProducto) -> Unit
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(CategoriaProducto.lista) { categoria ->
            val activa = categoria == seleccionada
            FilterChip(
                selected = activa,
                onClick = { onSeleccionar(categoria) },
                label = {
                    Text(
                        text = categoria.titulo,
                        fontWeight = if (activa) FontWeight.Bold else FontWeight.Medium
                    )
                },
                leadingIcon = {
                    Icon(categoria.icono(), contentDescription = null, modifier = Modifier.size(18.dp))
                },
                shape = RoundedCornerShape(20.dp),
                border = null,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = AzulSuave,
                    labelColor = TextoOscuro,
                    iconColor = TextoOscuro,
                    selectedContainerColor = AzulPawsy,
                    selectedLabelColor = Color.White,
                    selectedLeadingIconColor = Color.White
                )
            )
        }
    }
}
