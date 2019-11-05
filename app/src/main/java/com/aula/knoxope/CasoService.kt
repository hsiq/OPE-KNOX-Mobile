package com.aula.knoxope

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object CasoService {


    val host = "https://knoxapp180120.herokuapp.com/processo"

    fun getCaso (context: Context): List<Caso> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host"
            val json = HttpHelper.get(url)
            Log.d("BATATA",json)
            return parserJson(json)
        } else {
            Log.d("BATATA",ArrayList<Caso>().toString())
            return ArrayList<Caso>()
        }
    }


    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}