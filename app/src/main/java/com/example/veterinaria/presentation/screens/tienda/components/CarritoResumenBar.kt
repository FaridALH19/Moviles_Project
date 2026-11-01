package com.example.veterinaria.presentation.screens.tienda.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.BarraCarrito
import com.example.veterinaria.ui.theme.BotonCarrito
import com.example.veterinaria.ui.theme.NaranjaTexto
import com.example.veterinaria.util.aSoles

@Composable
fun CarritoResumenBar(
    cantidad: Int,
    total: Double,
    onVerCarrito: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(BarraCarrito, RoundedCornerShape(30.dp))
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Box {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(42.dp)
                    .background(AzulPawsy, CircleShape)
            ) {
                Icon(Icons.Filled.ShoppingCart, contentDescription = null, tint = Color.White)
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 3.dp, y = (-3).dp)
                    .size(18.dp)
                    .background(NaranjaTexto, CircleShape)
            ) {
                Text(cantidad.toString(), color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = if (cantidad == 1) "1 producto" else "$cantidad productos",
                color = Color(0xFFC9CDD8),
                fontSize = 12.sp
            )
            Text(text = total.aSoles(), color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = onVerCarrito,
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BotonCarrito),
            modifier = Modifier.height(44.dp)
        ) {
            Text("Ver Carrito", fontSize = 15.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(18.dp))
        }
    }
}
