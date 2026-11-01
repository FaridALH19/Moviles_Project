package com.example.veterinaria.data.mapper

import com.example.veterinaria.data.local.entity.CalificacionEntity
import com.example.veterinaria.data.local.entity.CarritoItemEntity
import com.example.veterinaria.data.local.entity.ProductoEntity
import com.example.veterinaria.domain.model.AspectoDestacado
import com.example.veterinaria.domain.model.Calificacion
import com.example.veterinaria.domain.model.CarritoItem
import com.example.veterinaria.domain.model.CategoriaProducto
import com.example.veterinaria.domain.model.InsigniaProducto
import com.example.veterinaria.domain.model.Producto

fun ProductoEntity.toDomain() = Producto(
    id = id,
    nombre = nombre,
    descripcion = descripcion,
    categoria = CategoriaProducto.desdeId(categoria),
    etiqueta = etiqueta,
    insignia = insignia?.let { InsigniaProducto.desdeId(it) },
    precio = precio,
    precioAnterior = precioAnterior,
    imagen = imagen,
    requiereReceta = requiereReceta,
    esFavorito = esFavorito,
    reservado = reservado
)

fun CarritoItemEntity.toDomain() = CarritoItem(productoId = productoId, cantidad = cantidad)

fun CalificacionEntity.toDomain() = Calificacion(
    id = id,
    citaId = citaId,
    estrellas = estrellas,
    aspectos = aspectos.split(",")
        .filter { it.isNotBlank() }
        .mapNotNull { AspectoDestacado.desdeId(it) }
        .toSet(),
    comentario = comentario,
    fecha = fecha
)

fun Calificacion.toEntity() = CalificacionEntity(
    id = id,
    citaId = citaId,
    estrellas = estrellas,
    aspectos = aspectos.joinToString(",") { it.id },
    comentario = comentario,
    fecha = fecha
)
