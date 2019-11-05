package com.aula.knoxope

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Console

object DisciplinaService {


    val host = "https://knoxapp180120.herokuapp.com/cliente"

    fun getDisciplinas (context: Context): List<Disciplina> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host"
            val json = HttpHelper.get(url)
            Log.d("BATATA",json)

            return parserJson(json)
        } else {
            Log.d("BATATA",ArrayList<Disciplina>().toString())

            return ArrayList<Disciplina>()
        }
    }

    fun save(disciplina: Advogado): Response {
        val json = HttpHelper.post("$host/disciplinas", disciplina.toJson())
        return parserJson(json)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}