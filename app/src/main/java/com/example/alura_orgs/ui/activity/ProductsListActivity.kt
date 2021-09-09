package com.example.alura_orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alura_orgs.dao.ProductsDao
import com.example.alura_orgs.databinding.ActivityProductsListBinding
import com.example.alura_orgs.ui.adapter.ProductListAdapter

class ProductsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsListBinding
    private val dao = ProductsDao()
    private val adapter = ProductListAdapter(context = this, products = dao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsListBinding.inflate(layoutInflater)
        val view = binding.productListRoot
        setContentView(view)

        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        adapter.update(dao.searchAll())
        configureFab()
    }

    private fun configureRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun configureFab() {
        val buttonAdd = binding.floatingActionButton
        buttonAdd.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }

}