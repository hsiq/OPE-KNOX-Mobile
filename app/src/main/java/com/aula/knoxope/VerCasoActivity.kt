package com.aula.knoxope

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_ver_caso.*
import android.content.Intent
import android.net.Uri


class VerCasoActivity : AppCompatActivity() {

    private val context: Context get() = this
    var caso: Caso? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_caso)

        // recuperar onjeto de Disciplina da Intent
        caso = intent.getSerializableExtra("caso") as Caso

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = caso?.assunto

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplina

        assunto.text = caso?.assunto
        numeroProcesso.text = "Numero do processo: " +caso?.numeroProcesso.toString()
        juiz.text = "Juiz: "+ caso?.juiz
        classe.text = "Classe: " + caso?.classe
        local.text = "Local: " +caso?.local
        url.text = "URL: "+ caso?.url


        downloadButton.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(caso?.url)
            startActivity(openURL)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado
        // remover a disciplina no WS

        // botão up navigation
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
