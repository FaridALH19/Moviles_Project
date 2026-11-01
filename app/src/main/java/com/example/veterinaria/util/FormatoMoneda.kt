package com.example.veterinaria.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

private val formatoSoles = DecimalFormat("#,##0.00", DecimalFormatSymbols(Locale.US))

/** Convierte un monto a texto en soles peruanos. Ej: 159.9 -> "S/ 159.90" */
fun Double.aSoles(): String = "S/ ${formatoSoles.format(this)}"
