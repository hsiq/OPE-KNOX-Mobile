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



    var foto = "https://www.pngfind.com/pngs/m/515-5153597_cliente-icon-png-customer-icon-vector-png-transparent.png"

    override fun toString(): String {
        return "Disciplina(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}