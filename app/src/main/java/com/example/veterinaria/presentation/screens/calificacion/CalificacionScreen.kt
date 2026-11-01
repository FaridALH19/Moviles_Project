package com.example.veterinaria.presentation.screens.calificacion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.veterinaria.domain.model.AspectoDestacado
import com.example.veterinaria.presentation.screens.calificacion.components.AspectosDestacados
import com.example.veterinaria.presentation.screens.calificacion.components.ComentarioYEnvio
import com.example.veterinaria.presentation.screens.calificacion.components.EstrellasRating
import com.example.veterinaria.presentation.screens.calificacion.components.IconoMascotaCalificacion
import com.example.veterinaria.ui.theme.AzulPawsy
import com.example.veterinaria.ui.theme.GrisHeader
import com.example.veterinaria.ui.theme.TextoGris
import com.example.veterinaria.ui.theme.TextoOscuro

@Composable
fun CalificacionScreen(viewModel: CalificacionViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    CalificacionContent(
        uiState = uiState,
        onEstrellas = viewModel::onEstrellasSeleccionadas,
        onAspecto = viewModel::onAspectoClick,
        onComentario = viewModel::onComentarioChange,
        onEnviar = viewModel::onEnviar
    )
}

@Composable
fun CalificacionContent(
    uiState: CalificacionUiState,
    onEstrellas: (Int) -> Unit,
    onAspecto: (AspectoDestacado) -> Unit,
    onComentario: (String) -> Unit,
    onEnviar: () -> Unit
) {
    // Franja gris de fondo + hoja blanca redondeada encima (como el prototipo)
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(GrisHeader)
        )

        val cita = uiState.cita
        if (uiState.cargando || cita == null) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp))
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            IconoMascotaCalificacion()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "¿Cómo fue la atención de ${cita.mascota} hoy?",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextoOscuro,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = buildAnnotatedString {
                    append("Cita con ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold, color = TextoOscuro)) {
                        append(cita.veterinario)
                    }
                    append(" finalizada a las ${cita.horaFin} hrs en ")
                    withStyle(SpanStyle(color = AzulPawsy)) { append(cita.clinica) }
                    append(".")
                },
                fontSize = 13.sp,
                color = TextoGris,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            EstrellasRating(
                estrellas = uiState.estrellas,
                texto = uiState.textoEstrellas,
                habilitado = !uiState.enviada,
                onSeleccionar = onEstrellas
            )

            Spacer(modifier = Modifier.height(18.dp))

            AspectosDestacados(
                seleccionados = uiState.aspectos,
                habilitado = !uiState.enviada,
                onClick = onAspecto
            )

            Spacer(modifier = Modifier.height(18.dp))

            ComentarioYEnvio(
                comentario = uiState.comentario,
                enviando = uiState.enviando,
                enviada = uiState.enviada,
                error = uiState.error,
                onComentario = onComentario,
                onEnviar = onEnviar
            )
        }
    }
}
