package com.example.agendapersonas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agendapersonas.databinding.PersonViewBinding





class PersonaAdapter(private val personas: List<Persona> ,val listener: (Persona) -> Unit):RecyclerView.Adapter<PersonaAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=PersonViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val persona = personas[position]
        holder.bin(persona)
        holder.itemView.setOnClickListener {
            listener(persona)
        }
    }

    override fun getItemCount(): Int {
        return personas.size
    }
    class ViewHolder(private val binding: PersonViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(persona: Persona){
            binding.nombre.text=persona.nombre
            binding.numero.text=persona.numero
            binding.email.text=persona.email

            Glide.with(binding.foto)
                .load(persona.urlImagen)
                .into(binding.foto)

        }
    }
}


