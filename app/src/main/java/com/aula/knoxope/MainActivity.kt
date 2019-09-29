package com.aula.knoxope

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val botaoclientes = findViewById<Button>(R.id.clientes)
        botaoclientes.setOnClickListener { onClickCliente() }

        val botaocasos = findViewById<Button>(R.id.casos)
        botaocasos.setOnClickListener { onClickCaso() }

        val botaorelatorio = findViewById<Button>(R.id.relatorio)
        botaorelatorio.setOnClickListener { onClickRelatorio() }
    }


    fun onClickCliente(){
        val intent = Intent(context, ListarActivity::class.java)
        val params = Bundle()
        params.putString("nome", "Clientes")
        intent.putExtras(params)
        startActivityForResult(intent, 1)

    }
    fun onClickCaso(){
        val intent = Intent(context, ListarActivity::class.java)
        val params = Bundle()
        params.putString("nome", "Casos")
        intent.putExtras(params)
        startActivityForResult(intent, 1)

    }

    fun onClickRelatorio(){
        val intent = Intent(context, ListarActivity::class.java)
        val params = Bundle()
        params.putString("nome", "Relatório")
        intent.putExtras(params)
        startActivityForResult(intent, 1)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem Toast na tela
        // a comparação é feita com o recurso de id definido no xml
        if  (id == R.id.action_buscar) {
            Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {

           //loading
            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.progress_dialog,null)
            val message = dialogView.findViewById<TextView>(R.id.message)
            message.text = "Carregando..."
            builder.setView(dialogView)
            builder.setCancelable(false)
            val dialog = builder.create()
            dialog.show()

            Handler().postDelayed({dialog.dismiss()},3000)

        } else if (id == R.id.action_config) {
            Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()
            val intent = Intent(context, ConfiguracaoActivity::class.java)
            startActivityForResult(intent, 1)
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}



