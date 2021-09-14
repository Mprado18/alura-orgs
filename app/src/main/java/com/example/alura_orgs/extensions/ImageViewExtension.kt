package com.example.alura_orgs.extensions

import android.widget.ImageView
import coil.load
import com.example.alura_orgs.R

fun ImageView.uploadImage(
    url: String? = null,
    fallback: Int = R.drawable.ic_error,
    error: Int = R.drawable.ic_error,
    placeholder: Int = R.drawable.placeholder
) {
    load(url) {
        fallback(fallback)
        error(error)
        placeholder(placeholder)
    }
}