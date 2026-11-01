package com.example.veterinaria.presentation.navigation

object RutasNav {
    const val INICIO = "inicio"
    const val MASCOTAS = "mascotas"
    const val AGENDAR = "agendar"
    const val TIENDA = "tienda"
    const val HISTORIAL = "historial"   // Pantalla de calificación de la cita
    const val CARRITO = "carrito"

    // Subtítulo que aparece debajo de "Pawsy" en la barra superior
    fun getSubtitulo(ruta: String?): String = when (ruta) {
        INICIO -> "Inicio"
        MASCOTAS -> "Mis Mascotas"
        AGENDAR -> "Agendar"
        TIENDA -> "Tienda"
        HISTORIAL -> "Historial"
        CARRITO -> "Carrito"
        else -> "Pawsy"
    }
}
