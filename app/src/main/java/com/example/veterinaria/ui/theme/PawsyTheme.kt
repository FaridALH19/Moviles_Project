package com.example.veterinaria.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Tema con los colores del prototipo Pawsy.
// Usa "Typography" del archivo Type.kt original de Veterinaria.
private val PawsyColorScheme = lightColorScheme(
    primary = AzulPawsy,
    onPrimary = Color.White,
    secondary = MentaTexto,
    background = FondoPawsy,
    surface = Color.White,
    onBackground = TextoOscuro,
    onSurface = TextoOscuro
)

@Composable
fun PawsyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PawsyColorScheme,
        typography = Typography,
        content = content
    )
}
