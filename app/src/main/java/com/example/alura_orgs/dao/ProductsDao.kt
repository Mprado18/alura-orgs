package com.example.alura_orgs.dao

import com.example.alura_orgs.model.Products

class ProductsDao {

    fun add(product: Products) {
        products.add(product)
    }

    fun searchAll(): List<Products> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Products>()
    }

}