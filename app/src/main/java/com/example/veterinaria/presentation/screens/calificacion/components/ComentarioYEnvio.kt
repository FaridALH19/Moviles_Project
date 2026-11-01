package com.example.veterinaria.presentation.screens.calificacion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.Borde
import com.example.veterinaria.ui.theme.MentaFondo
import com.example.veterinaria.ui.theme.MentaTexto
import com.example.veterinaria.ui.theme.RojoTexto
import com.example.veterinaria.ui.theme.TextoGris

@Composable
fun ComentarioYEnvio(
    comentario: String,
    enviando: Boolean,
    enviada: Boolean,
    error: String?,
    onComentario: (String) -> Unit,
    onEnviar: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = comentario,
            onValueChange = onComentario,
            enabled = !enviada,
            label = { Text("Déjanos un comentario (opcional)") },
            supportingText = { Text("${comentario.length}/300", color = TextoGris) },
            minLines = 3,
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AzulPawsy,
                unfocusedBorderColor = Borde
            ),
            modifier = Modifier.fillMaxWidth()
        )

        error?.let {
            Text(text = it, color = RojoTexto, fontSize = 12.sp, modifier = Modifier.padding(bottom = 6.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (enviada) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MentaFondo, RoundedCornerShape(14.dp))
                    .padding(14.dp)
            ) {
                Icon(Icons.Filled.CheckCircle, contentDescription = null, tint = MentaTexto)
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "¡Gracias! Tu calificación fue registrada.",
                    color = MentaTexto,
                    fontWeight = FontWeight.SemiBold
                )
            }
        } else {
            Button(
                onClick = onEnviar,
                enabled = !enviando,
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AzulPawsy),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                if (enviando) {
                    CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp, modifier = Modifier.size(20.dp))
                } else {
                    Text("Enviar calificación", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
            }
        }
    }
}
