package com.aula.knoxope

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    private var advogados = listOf<Advogado>()
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val botaoLogin = findViewById<Button>(R.id.botao_login)
        botaoLogin.setOnClickListener {onClickLogin() }
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome = Prefs.getString("lembrarNome")
            var lembrarSenha = Prefs.getString("lembrarSenha")
            email.setText(lembrarNome)
            senha.setText(lembrarSenha)
            checkBoxLogin.isChecked = lembrar
        }

    }

    fun onClickLogin(){
        val email = findViewById<EditText>(R.id.email)
        val senha = findViewById<EditText>(R.id.senha)
        val valorEmail = email.text.toString()
        val valorSenha = senha.text.toString()


        // armazenar valor do checkbox
        Prefs.setBoolean("lembrar", checkBoxLogin.isChecked)
        // verificar se é para pembrar nome e senha
        if (checkBoxLogin.isChecked) {
            Prefs.setString("lembrarNome", valorEmail)
            Prefs.setString("lembrarSenha", valorSenha)
        } else{
            Prefs.setString("lembrarNome", "")
            Prefs.setString("lembrarSenha", "")
        }

        //val advogadoLogin = AdvogadoLogin()
       // advogadoLogin.email = valorEmail
        //advogadoLogin.senha = valorSenha
        //val advogadoPerfil = AdvogadoService.login(advogadoLogin)

        //Log.d("BATATA",advogadoPerfil.toString())
        if (valorEmail == "aluno"&& valorSenha == "impacta"){
            val intent = Intent(context, ListClienteActivity::class.java)
            startActivityForResult(intent, 1)

        }else{
            Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()

        }



    }



}
