package com.example.alura_orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alura_orgs.common.PRODUCT_KEY
import com.example.alura_orgs.databinding.ActivityProductsDetailBinding
import com.example.alura_orgs.extensions.formatValueToBrType
import com.example.alura_orgs.extensions.uploadImage
import com.example.alura_orgs.model.Products

class ProductsDetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityProductsDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.productsDetailRoot)

        renderProductsIfExist()
    }

    private fun renderProductsIfExist() {
        intent.getParcelableExtra<Products>(PRODUCT_KEY)?.let { productIsRender ->
            completeInputInfo(productIsRender)
        } ?: finish()
    }

    private fun completeInputInfo(productIsRender: Products) {
        with(binding) {
            productDetailImage.uploadImage(productIsRender.image)
            productDetailTitle.text = productIsRender.title
            productDetailDescription.text = productIsRender.description
            productDetailValue.text = productIsRender.value.formatValueToBrType()
        }
    }

}