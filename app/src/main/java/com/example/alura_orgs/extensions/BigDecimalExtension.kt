package com.example.alura_orgs.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.formatValueToBrType(): String {
    val formatator: NumberFormat = NumberFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return formatator.format(this)
}