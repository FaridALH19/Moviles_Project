package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.domain.model.Producto
import com.example.veterinaria.presentation.common.ImagenDrawable
import com.example.veterinaria.ui.theme.AzulClaro
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.AzulSuave
import com.example.veterinaria.ui.theme.MentaTexto
import com.example.veterinaria.ui.theme.TextoGris
import com.example.veterinaria.ui.theme.TextoOscuro
import com.example.veterinaria.util.aSoles

@Composable
fun ProductoCard(
    producto: Producto,
    onFavorito: () -> Unit,
    onAgregar: () -> Unit,
    onReservar: () -> Unit
) {
    // Color de la etiqueta superior según categoría (azul / verde / gris como en el prototipo)
    val colorEtiqueta = when (producto.categoria) {
        CategoriaProducto.ALIMENTOS -> AzulPawsy
        CategoriaProducto.FARMACIA, CategoriaProducto.HIGIENE -> MentaTexto
        else -> TextoGris
    }

    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            producto.insignia?.let { InsigniaChip(it) }
            Spacer(modifier = Modifier.height(8.dp))

            // Imagen dentro de la "burbuja" + botón de favorito
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.95f)
                    .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp, bottomStart = 60.dp, bottomEnd = 60.dp))
                    .background(AzulSuave),
                contentAlignment = Alignment.Center
            ) {
                ImagenDrawable(
                    nombre = producto.imagen,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                )
                IconButton(
                    onClick = onFavorito,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                        .size(30.dp)
                        .background(Color.White, CircleShape)
                ) {
                    Icon(
                        imageVector = if (producto.esFavorito) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = "Favorito",
                        tint = if (producto.esFavorito) Color(0xFFE53935) else TextoOscuro,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = producto.etiqueta,
                color = colorEtiqueta,
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 1
            )
            Text(
                text = producto.nombre,
                color = TextoOscuro,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 17.sp,
                maxLines = 2,
                minLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = producto.descripcion,
                color = TextoGris,
                fontSize = 11.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Precio en soles (+ precio anterior tachado si hay oferta)
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = producto.precio.aSoles(),
                    color = TextoOscuro,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                producto.precioAnterior?.let {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = it.aSoles(),
                        color = TextoGris,
                        fontSize = 10.sp,
                        textDecoration = TextDecoration.LineThrough,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Los productos con receta se "Reservan"; los demás se "Añaden"
            when {
                producto.requiereReceta && producto.reservado ->
                    BotonProducto("Reservado", Icons.Outlined.CheckCircle, AzulClaro, AzulPawsy, enabled = false) { }
                producto.requiereReceta ->
                    BotonProducto("Reservar", Icons.Outlined.CalendarMonth, AzulClaro, AzulPawsy, onClick = onReservar)
                else ->
                    BotonProducto("Añadir", Icons.Outlined.AddShoppingCart, AzulPawsy, Color.White, onClick = onAgregar)
            }
        }
    }
}

@Composable
private fun BotonProducto(
    texto: String,
    icono: ImageVector,
    fondo: Color,
    contenido: Color,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = fondo,
            contentColor = contenido,
            disabledContainerColor = fondo,
            disabledContentColor = contenido
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Icon(icono, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = texto, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
    }
}
