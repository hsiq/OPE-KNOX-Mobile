package com.aula.knoxope


import com.google.gson.GsonBuilder
import java.io.Serializable

class AdvogadoLogin : Serializable {

    var senha = ""
    var email = ""



    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}