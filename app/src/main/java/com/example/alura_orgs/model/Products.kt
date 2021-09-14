package com.example.alura_orgs.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Products(
    val title: String,
    val description: String,
    val value: BigDecimal,
    val image: String? = null
) : Parcelable
