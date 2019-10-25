package com.aula.knoxope

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_cliente.*


class ClienteActivity : AppCompatActivity() {

    private val context: Context get() = this
    var disciplina: Disciplina? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        // recuperar onjeto de Disciplina da Intent
        disciplina = intent.getSerializableExtra("disciplina") as Disciplina

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = disciplina?.nome

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplina
        nomeDisciplina.text = disciplina?.nome
        cpf.text = "CPF: " +disciplina?.cpf.toString()
        rg.text = "RG:"+ disciplina?.rg
        telefone.text = "Telefone:" + disciplina?.telefoneComercial




        Picasso.with(this).load(disciplina?.foto).fit().into(imagemDisciplina,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })
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
