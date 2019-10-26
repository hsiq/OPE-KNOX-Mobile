package com.aula.knoxope


import com.google.gson.GsonBuilder
import java.io.Serializable

class Advogado : Serializable {

    var cpf:Long = 0
    var nome = ""
    var rg = ""
    var email = ""
    var cargo = ""
    var celular = ""
    var pis = ""
    var carteira_trabalho = ""
    var cep = ""



    var foto = "https://image.flaticon.com/icons/png/512/16/16480.png"
    //var foto = "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"

    override fun toString(): String {
        return "Disciplina(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}