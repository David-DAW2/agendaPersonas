package com.example.agendapersonas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.agendapersonas.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {
    companion object {
        const val EXTRA_PERSONA= "personaElegida"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDetailBinding.bind(view)
        val persona = arguments?.getParcelable<Persona>(EXTRA_PERSONA)
        if (persona != null) {
            (requireActivity() as AppCompatActivity).supportActionBar?.title = persona.nombre
            binding.nombreDetail.text=persona.nombre
            binding.numeroDetail.text=persona.numero
            binding.emailDetail.text=persona.email
            binding.llamar.setOnClickListener(){
                val intent= Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+persona.numero))

                startActivity(intent)

            }
            binding.mandarEmail.setOnClickListener(){
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:"+persona.email)
                }
                startActivity(intent)

            }
            Glide.with(binding.fotoDetail)
                .load(persona.urlImagen)
                .into(binding.fotoDetail)
        }
        }

    }




