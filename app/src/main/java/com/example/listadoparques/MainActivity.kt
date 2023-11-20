package com.example.listadoparques

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadoparques.adapter.ParqueAdapter
import com.example.listadoparques.databinding.ActivityMainBinding

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTitle("ListadoParques")
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        var adapter =ParqueAdapter(ParqueProvider.parqueList)
        binding.recycler.adapter= adapter

        binding.filtro.addTextChangedListener { filtro ->
            val filtroParque = ParqueProvider.parqueList.filter { parque ->
                parque.descripcion.lowercase().contains(filtro.toString().lowercase())  }
            adapter.actualizarParques(filtroParque)
        }
    }
}