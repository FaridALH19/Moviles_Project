package com.example.veterinaria.presentation.common

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Muestra una imagen de res/drawable buscándola por su nombre (ej: "producto_kong").
 * Si todavía no agregaste la imagen, muestra una huella como reemplazo
 * para que la app compile y funcione igual.
 */
@SuppressLint("DiscouragedApi", "LocalContextResourcesRead")
@Composable
fun ImagenDrawable(
    nombre: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    val context = LocalContext.current
    val resId = remember(nombre) {
        context.resources.getIdentifier(nombre, "drawable", context.packageName)
    }
    if (resId != 0) {
        Image(
            painter = painterResource(id = resId),
            contentDescription = nombre,
            contentScale = contentScale,
            modifier = modifier
        )
    } else {
        Box(modifier = modifier, contentAlignment = Alignment.Center) {
            Icon(
                imageVector = Icons.Filled.Pets,
                contentDescription = null,
                tint = Color(0xFF9AA6C8),
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
