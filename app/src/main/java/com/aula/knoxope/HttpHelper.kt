package com.aula.knoxope

import android.util.Log
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException

object HttpHelper {


    val JSON = MediaType.parse("application/json; charset=utf-8")

    var client = OkHttpClient()

    // GET
    fun get(url:String): String {
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    // POST JSON
    fun post(url: String, json: String): String {
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    // DELETE
    fun delete(url: String): String {
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }


    // Lê resposta em formato JSON
    private fun getJson(request: Request?): String {
        val response = client.newCall(request).execute()
        val body = response.body()
        if (body != null) {
            val json = body.string()
            return json
        }
        throw IOException("Erro na requisição")
    }
}