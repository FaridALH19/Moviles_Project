package com.example.veterinaria.domain.model

// Data class: etiqueta pequeña que aparece arriba de cada tarjeta de producto
data class InsigniaProducto(
    val id: String,
    val texto: String
) {
    companion object {
        val REC_VETERINARIO = InsigniaProducto("REC_VETERINARIO", "Rec. por veterinario")
        val RECETA = InsigniaProducto("RECETA", "Receta requerida")
        val RESISTENTE = InsigniaProducto("RESISTENTE", "Resistente")
        val PIEL_SENSIBLE = InsigniaProducto("PIEL_SENSIBLE", "Piel Sensible")

        val lista = listOf(REC_VETERINARIO, RECETA, RESISTENTE, PIEL_SENSIBLE)

        fun desdeId(id: String): InsigniaProducto? = lista.firstOrNull { it.id == id }
    }
}
