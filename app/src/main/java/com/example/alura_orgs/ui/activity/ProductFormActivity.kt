package com.example.alura_orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.alura_orgs.R
import com.example.alura_orgs.dao.ProductsDao
import com.example.alura_orgs.model.Products
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private val dao = ProductsDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_form)

        val inputTitle = findViewById<EditText>(R.id.inputTitle)
        val inputDescription = findViewById<EditText>(R.id.inputDescription)
        val inputValue = findViewById<EditText>(R.id.inputValue)
        val buttonSave = findViewById<Button>(R.id.buttonSave)

        configureButtonSave(buttonSave, inputTitle, inputDescription, inputValue)
    }

    private fun configureButtonSave(
        buttonSave: Button,
        inputTitle: EditText,
        inputDescription: EditText,
        inputValue: EditText
    ) {
        buttonSave.setOnClickListener {
            val title = inputTitle.text.toString()
            val description = inputDescription.text.toString()
            val value = inputValue.text.toString()

            val valueConverted = if (value.isBlank()) BigDecimal.ZERO else BigDecimal(value)

            val newProduct = Products(
                title = title,
                description = description,
                value = valueConverted
            )

            dao.add(newProduct)
            finish()
        }
    }

}