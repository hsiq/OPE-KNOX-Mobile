package com.aula.knoxope

import com.google.gson.GsonBuilder
import java.io.Serializable

class Caso : Serializable {

    var numeroProcesso:Long = 0
    var classe = ""
    var assunto = ""
    var cpfAdvogado = ""
    var cpfCliente = ""
    var juiz = ""
    var local = ""
    var status = ""
    var url= ""


    var foto = "https://infotrust.pt/wp-content/uploads/2017/02/icon-title.png"
    //var foto = "https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png"

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}