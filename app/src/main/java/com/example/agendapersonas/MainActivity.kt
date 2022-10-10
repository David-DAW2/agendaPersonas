package com.example.agendapersonas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.agendapersonas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter=PersonaAdapter(
            listOf(
            Persona("Juan", "656640331","https://loremflickr.com/320/240/random","nandito@gmail.com"),
            Persona("Pedro", "335333444","https://loremflickr.com/320/240/random","nanditee@gmail.com"),
            Persona("lucia", "22233444","https://loremflickr.com/320/240/random","nandimere@gmail.com"),
            Persona("Julian", "000033444","https://loremflickr.com/320/240/random","nandosio@gmail.com"),
            Persona("Sara", "999993444","https://loremflickr.com/320/240/random","nanduto@gmail.com"),
            Persona("Ismael", "999993444","https://loremflickr.com/320/240/random","nansalsa@gmail.com"),
                    Persona("Nieves", "000033444","https://loremflickr.com/320/240/random","nansup@gmail.com"),
            Persona("Martin", "999993444","https://loremflickr.com/320/240/random","neeoo@gmail.com"),
            Persona("paco", "999993444","https://loremflickr.com/320/240/random","nunuo@gmail.com")
        ), { persona ->
            val intent = Intent(this@MainActivity, Personadetail::class.java)
                intent.putExtra(Personadetail.EXTRA_PERSONA, persona)
                startActivity(intent)



            })


    }
}