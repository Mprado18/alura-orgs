package com.example.alura_orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.alura_orgs.dao.ProductsDao
import com.example.alura_orgs.databinding.ActivityProductFormBinding
import com.example.alura_orgs.databinding.ActivityProductFormBinding.inflate
import com.example.alura_orgs.extensions.uploadImage
import com.example.alura_orgs.model.Products
import com.example.alura_orgs.ui.dialog.FormDialog
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductFormBinding
    private val dao = ProductsDao()
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        val view = binding.productFormRoot
        setContentView(view)
        title = "Cadastrar produto"

        val inputTitle = binding.inputTitle
        val inputDescription = binding.inputDescription
        val inputValue = binding.inputValue
        val buttonSave = binding.buttonSave

        configureButtonSave(buttonSave, inputTitle, inputDescription, inputValue)
        binding.productImage.setOnClickListener {
            FormDialog(this).showDialog(url) { image ->
                url = image
                binding.productImage.uploadImage(url)
            }
        }
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
                value = valueConverted,
                image = url
            )

            dao.add(newProduct)
            finish()
        }
    }

}