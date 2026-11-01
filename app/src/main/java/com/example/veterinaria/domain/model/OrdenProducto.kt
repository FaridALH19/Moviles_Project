package com.example.veterinaria.domain.model

// Data class: opciones del menú "Ordenar por"
data class OrdenProducto(
    val id: String,
    val titulo: String
) {
    companion object {
        val RELEVANCIA = OrdenProducto("RELEVANCIA", "Relevancia")
        val MENOR_PRECIO = OrdenProducto("MENOR_PRECIO", "Menor precio")
        val MAYOR_PRECIO = OrdenProducto("MAYOR_PRECIO", "Mayor precio")

        val lista = listOf(RELEVANCIA, MENOR_PRECIO, MAYOR_PRECIO)
    }
}
