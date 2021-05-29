package com.uvg.vistas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_lista.*
import kotlinx.android.synthetic.main.item_lista.view.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador({clickListener -> showItemClick(clickListener)}, {longClickListener -> changeItemClick(longClickListener)})
    private val items : MutableList<String> = mutableListOf()
    private var cont = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")
        items.add("Prueba 4")
        items.add("Prueba 5")

        btnag.setOnClickListener {
            cont++
            val item = "Prueba" + cont
            items.add(item)
            adaptador.setItems(items)
        }
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter =adaptador
        adaptador.setItems(items)

    }

    fun showItemClick(position: Int){
        val item = adaptador.getItem(position)
        items.remove(item)
        adaptador.setItems(items)
    }

    private fun changeItemClick(position: Int) {
        var item = adaptador.getItem(position)
        items[position] = "Changed"
        adaptador.setItems(items)

    }
}