package com.example.veterinaria.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.veterinaria.presentation.navigation.RutasNav
import com.example.veterinaria.ui.theme.AzulClaro
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.Borde
import com.example.veterinaria.ui.theme.TextoOscuro
import com.example.veterinaria.ui.theme.TextoGris

@Composable
fun AppTopBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val ruta = navBackStackEntry?.destination?.route
    val subtitulo = RutasNav.getSubtitulo(ruta)

    Column(modifier = Modifier.background(Color.White).statusBarsPadding()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo Pawsy  -> res/drawable/logo_pawsy
            ImagenDrawable(
                nombre = "logo_pawsy",
                modifier = Modifier
                    .size(38.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(AzulClaro)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = "Pawsy", color = AzulPawsy, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = subtitulo, color = TextoGris, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.weight(1f))

            // Campana con punto rojo de notificación
            IconButton(onClick = { }) {
                Box {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notificaciones",
                        tint = TextoOscuro
                    )
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .align(Alignment.TopEnd)
                            .offset(x = 1.dp, y = (-1).dp)
                            .background(Color(0xFFE53935), CircleShape)
                    )
                }
            }

            // Foto de perfil -> res/drawable/avatar_usuario
            ImagenDrawable(
                nombre = "avatar_usuario",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(AzulClaro)
            )
        }
        HorizontalDivider(thickness = 1.dp, color = Borde)
    }
}
