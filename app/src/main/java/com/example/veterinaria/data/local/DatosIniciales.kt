package com.example.veterinaria.data.local

import com.example.veterinaria.data.local.entity.ProductoEntity
import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.domain.model.CitaFinalizada
import com.example.veterinaria.domain.model.InsigniaProducto

// Datos que se insertan en Room la primera vez que se abre la app.
// Los nombres de "imagen" deben coincidir con los archivos de res/drawable.
object DatosIniciales {

    val productos = listOf(
        ProductoEntity(
            id = 1,
            nombre = "Royal Canin Puppy Medium 3kg",
            descripcion = "Alimento súper premium para cachorros de raza mediana",
            categoria = CategoriaProducto.ALIMENTOS.id,
            etiqueta = "NUTRICIÓN CANINA",
            insignia = InsigniaProducto.REC_VETERINARIO.id,
            precio = 159.90,
            precioAnterior = 189.90,
            imagen = "royal_canin",
            requiereReceta = false
        ),
        ProductoEntity(
            id = 2,
            nombre = "NexGard Spectra Antiparasitario",
            descripcion = "Perros 7.5 - 15kg masticable",
            categoria = CategoriaProducto.FARMACIA.id,
            etiqueta = "FARMACIA CLÍNICA",
            insignia = InsigniaProducto.RECETA.id,
            precio = 69.90,
            precioAnterior = null,
            imagen = "nex_gard",
            requiereReceta = true
        ),
        ProductoEntity(
            id = 3,
            nombre = "Kong Classic Interactivo",
            descripcion = "Goma ultra resistente para perros mordedores",
            categoria = CategoriaProducto.JUGUETES.id,
            etiqueta = "JUGUETE • ESTIMULACIÓN",
            insignia = InsigniaProducto.RESISTENTE.id,
            precio = 54.90,
            precioAnterior = null,
            imagen = "kong",
            requiereReceta = false
        ),
        ProductoEntity(
            id = 4,
            nombre = "Shampoo Avena & Aloe 500ml",
            descripcion = "Fórmula suave sin lágrimas",
            categoria = CategoriaProducto.HIGIENE.id,
            etiqueta = "HIGIENE DÉRMICA",
            insignia = InsigniaProducto.PIEL_SENSIBLE.id,
            precio = 39.90,
            precioAnterior = null,
            imagen = "shampoo",
            requiereReceta = false
        )
    )

    // Cita usada por la pantalla de calificación (el módulo de citas aún no existe)
    val ultimaCita = CitaFinalizada(
        id = 1,
        mascota = "Toby",
        veterinario = "Dra. Camila Morales",
        horaFin = "17:15",
        clinica = "Clínica Pawsy Central"
    )
}
