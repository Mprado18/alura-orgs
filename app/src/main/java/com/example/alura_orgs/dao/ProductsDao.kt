package com.example.alura_orgs.dao

import com.example.alura_orgs.model.Products
import java.math.BigDecimal

class ProductsDao {

    fun add(product: Products) {
        products.add(product)
    }

    fun searchAll(): List<Products> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Products>(
            Products(
                title = "Fruta assada",
                description = "Uma frutinha saborosa e assada",
                value = BigDecimal("25.00"),
                image = "https://www.fashionbubbles.com/wp-content/blogs.dir/1/files/2020/12/foto-v.png"
            ),
            Products(
                title = "Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups.",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                value = BigDecimal("1234"),
                image = "imagem inválida"
            ),
            Products(
                title = "Lorem ipsum is placeholder text commonly used in the graphic.",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                value = BigDecimal("549222"),
                image = "https://images.pexels.com/photos/46174/strawberries-berries-fruit-freshness-46174.jpeg"
            )
        )
    }

}