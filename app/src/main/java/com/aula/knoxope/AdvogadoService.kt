package com.aula.knoxope


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Console

object AdvogadoService {


    val host = "https://knoxapp180120.herokuapp.com/login/"
    val TAG = "WS_LMSApp"

    fun getAdvogados (context: Context): List<Advogado> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host"
            val json = HttpHelper.get(url)
            Log.d("BATATA",json)

            return parserJson(json)
        } else {
            return ArrayList<Advogado>()
        }
    }

    fun login(advogadoLogin: AdvogadoLogin): Response {
        val json = HttpHelper.post("$host", advogadoLogin.toJson())
        Log.d("BATATA",json)
        return parserJson(json)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}