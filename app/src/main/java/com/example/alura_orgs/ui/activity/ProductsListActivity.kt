package com.example.alura_orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alura_orgs.R
import com.example.alura_orgs.dao.ProductsDao
import com.example.alura_orgs.ui.adapter.ProductListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

//TODO alterar find view by id por view binding

class ProductsListActivity : AppCompatActivity() {

    private val dao = ProductsDao()
    private val adapter = ProductListAdapter(context = this, products = dao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list)

        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()

        adapter.update(dao.searchAll())
        configureFab()
    }

    private fun configureRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun configureFab() {
        val buttonAdd = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        buttonAdd.setOnClickListener {
            val intent = Intent(this, ProductFormActivity::class.java)
            startActivity(intent)
        }
    }

}