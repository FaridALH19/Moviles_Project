package com.example.veterinaria.domain.model

// Data class: opciones de "¿Qué fue lo más destacable?"
data class AspectoDestacado(
    val id: String,
    val texto: String
) {
    companion object {
        val ATENCION_CARINOSA = AspectoDestacado("ATENCION_CARINOSA", "Atención cariñosa ✨")
        val POCO_TIEMPO_ESPERA = AspectoDestacado("POCO_TIEMPO_ESPERA", "Poco tiempo de espera ⚡")
        val EXPLICACION_CLARA = AspectoDestacado("EXPLICACION_CLARA", "Explicación clara 🩺")
        val INSTALACIONES_LIMPIAS = AspectoDestacado("INSTALACIONES_LIMPIAS", "Instalaciones limpias 🧼")

        val lista = listOf(ATENCION_CARINOSA, POCO_TIEMPO_ESPERA, EXPLICACION_CLARA, INSTALACIONES_LIMPIAS)

        fun desdeId(id: String): AspectoDestacado? = lista.firstOrNull { it.id == id }
    }
}
