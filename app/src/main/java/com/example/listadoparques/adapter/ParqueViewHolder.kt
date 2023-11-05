package com.example.listadoparques.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listadoparques.Parque
import com.example.listadoparques.databinding.ItemParqueBinding


class ParqueViewHolder (view: View): RecyclerView.ViewHolder(view){
    val binding = ItemParqueBinding.bind(view)

    fun render(parqueModel: Parque){
        binding.tvNombre.text = parqueModel.parque
        binding.tvDescripcion.text = parqueModel.descripcion
        Glide.with(binding.fotoParque.context).load(parqueModel.foto).into(binding.fotoParque)
        binding.fotoParque.setOnClickListener{
            Toast.makeText(binding.fotoParque.context, parqueModel.parque, Toast.LENGTH_LONG).show()
        }
    }
}