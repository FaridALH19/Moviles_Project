package com.example.veterinaria.domain.model

// Data class: cada categoría tiene un id (se guarda en Room) y un título (se muestra en pantalla)
data class CategoriaProducto(
    val id: String,
    val titulo: String
) {
    // Object con las categorías disponibles en la tienda
    companion object {
        val TODOS = CategoriaProducto("TODOS", "Todos")
        val ALIMENTOS = CategoriaProducto("ALIMENTOS", "Alimentos & Dietas")
        val FARMACIA = CategoriaProducto("FARMACIA", "Farmacia")
        val JUGUETES = CategoriaProducto("JUGUETES", "Juguetes")
        val HIGIENE = CategoriaProducto("HIGIENE", "Higiene")

        val lista = listOf(TODOS, ALIMENTOS, FARMACIA, JUGUETES, HIGIENE)

        // Convierte el id guardado en Room a la categoría
        fun desdeId(id: String): CategoriaProducto = lista.firstOrNull { it.id == id } ?: TODOS
    }
}
