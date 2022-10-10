package com.example.agendapersonas

import android.content.Intent
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bumptech.glide.Glide
import com.example.agendapersonas.databinding.ActivityMainBinding
import com.example.agendapersonas.databinding.ActivityPersonadetailBinding

class Personadetail : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSONA= "personaElegida"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPersonadetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val persona = intent?.getParcelableExtra<Persona>(EXTRA_PERSONA) ?: throw
        IllegalStateException()
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


