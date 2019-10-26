package com.aula.knoxope

import com.google.gson.GsonBuilder
import java.io.Serializable

class Disciplina : Serializable {

    var cpf:Long = 0
    var nome = ""
    var rg = ""
    var logradouro = ""
    var nomeRua = ""
    var numero = ""
    var complemento = ""
    var cidade = ""
    var UF = ""
    var telefoneResidencial= ""
    var telefoneComercial = ""
    var celular = ""
    var email = ""
    var pis = ""
    var carteira_trabalho = ""
    var cep = ""



    var foto = R.drawable.people_ic
    //var foto = "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"

    override fun toString(): String {
        return "Disciplina(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}