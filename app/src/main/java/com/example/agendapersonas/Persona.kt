package com.example.agendapersonas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persona (val nombre:String, val numero: String , val urlImagen:String, val email:String ) :
    Parcelable {

}
