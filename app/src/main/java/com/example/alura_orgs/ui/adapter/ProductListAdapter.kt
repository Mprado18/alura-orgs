package com.example.alura_orgs.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alura_orgs.R
import com.example.alura_orgs.model.Products

class ProductListAdapter(
    private val context: Context,
    products: List<Products>
) : RecyclerView.Adapter<ProductListAdapter.mViewHolder>() {

    private val products = products.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)
        return mViewHolder(view)
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

    class mViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun addProduct(product: Products) {
            val title = itemView.findViewById<TextView>(R.id.label)
            title.text = product.title

            val description = itemView.findViewById<TextView>(R.id.description)
            description.text = product.description

            val value = itemView.findViewById<TextView>(R.id.value)
            value.text = product.value.toPlainString()


        }
    }

}
