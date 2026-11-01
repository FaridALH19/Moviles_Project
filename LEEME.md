# Veterinaria (Pawsy) – Tienda y Calificación (MVVM + Hilt + Room)

## Imágenes (las colocas tú)
Carpeta: app/src/main/res/drawable/
Nombres exactos (minúsculas, sin espacios ni guiones; .png, .jpg o .webp):

| Archivo              | Dónde aparece                         |
|----------------------|---------------------------------------|
| logo_pawsy           | Logo arriba a la izquierda            |
| avatar_usuario       | Foto de perfil arriba a la derecha    |
| royal_canin          | Tarjeta Royal Canin Puppy             |
| nex_gard             | Tarjeta NexGard Spectra               |
| kong                 | Tarjeta Kong Classic                  |
| shampoo              | Tarjeta Shampoo Avena & Aloe          |

Si falta una imagen, la app muestra una huella en su lugar (no se cae).
Para cambiar qué imagen usa un producto: data/local/DatosIniciales.kt -> campo "imagen".
Si cambias los datos iniciales, desinstala la app del emulador (Room ya guardó los anteriores).
