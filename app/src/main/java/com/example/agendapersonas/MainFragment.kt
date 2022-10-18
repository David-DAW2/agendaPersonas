package com.example.agendapersonas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

import com.example.agendapersonas.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view,savedInstanceState)
        val binding = FragmentMainBinding.bind(view)
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
        )
        ) { persona ->

                val fragment = DetailFragment()
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.container_view, fragment)
                    .commit()

                     fragment.arguments = bundleOf(DetailFragment.EXTRA_PERSONA to persona)

        }


    }
}