package com.example.alura_orgs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alura_orgs.databinding.ProductItemBinding
import com.example.alura_orgs.extensions.formatValueToBrType
import com.example.alura_orgs.extensions.uploadImage
import com.example.alura_orgs.model.Products

class ProductListAdapter(
    private val context: Context,
    products: List<Products>,
    var whenItemIsClicked: (product: Products) -> Unit = {}
) : RecyclerView.Adapter<ProductListAdapter.mViewHolder>() {

    private val products = products.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return mViewHolder(binding)
    }

    override fun onBindViewHolder(holder: mViewHolder, position: Int) {
        val product = products[position]
        holder.addProduct(product)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun update(products: List<Products>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    inner class mViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var product: Products

        init {
            binding.root.setOnClickListener {
                if (::product.isInitialized) {
                    whenItemIsClicked(product)
                }
            }
        }

        fun addProduct(product: Products) {
            this.product = product

            val title = binding.titleItem
            title.text = product.title

            val description = binding.description
            description.text = product.description

            val value = binding.value
            val valueFormated = product.value.formatValueToBrType()
            value.text = valueFormated

            val visibility = if (product.image != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            with(binding) {
                imageView.visibility = visibility
                imageView.uploadImage(product.image)
            }
        }
    }

}
