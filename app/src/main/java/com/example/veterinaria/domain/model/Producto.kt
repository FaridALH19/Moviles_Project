package com.example.veterinaria.domain.model

data class Producto(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val categoria: CategoriaProducto,
    val etiqueta: String,              // Ej: "NUTRICIÓN CANINA"
    val insignia: InsigniaProducto?,
    val precio: Double,                // En soles (S/)
    val precioAnterior: Double?,       // Precio tachado (oferta), puede ser null
    val imagen: String,                // Nombre del archivo en res/drawable (sin extensión)
    val requiereReceta: Boolean,
    val esFavorito: Boolean,
    val reservado: Boolean
)
