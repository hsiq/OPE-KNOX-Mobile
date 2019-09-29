package com.aula.knoxope

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val botaoLogin = findViewById<Button>(R.id.botao_login)
        botaoLogin.setOnClickListener {onClickLogin() }
    }

    fun onClickLogin(){
        val email = findViewById<EditText>(R.id.email)
        val senha = findViewById<EditText>(R.id.senha)
        val valorEmail = email.text.toString()
        val valorSenha = senha.text.toString()

        if (valorEmail == "aluno"&& valorSenha == "impacta"){
            val intent = Intent(context, MainActivity::class.java)
            startActivityForResult(intent, 1)

        }else{
            Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()

        }


    }

}
