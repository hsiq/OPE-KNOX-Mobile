package com.aula.knoxope

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.support.design.widget.NavigationView
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)




        setSupportActionBar(toolbar)




        val botaoclientes = findViewById<Button>(R.id.clientes)




        configuraMenuLateral()

        botaoclientes.setOnClickListener { onClickCliente() }

        val botaocasos = findViewById<Button>(R.id.casos)
        botaocasos.setOnClickListener { onClickCaso() }

        val botaorelatorio = findViewById<Button>(R.id.relatorio)
        botaorelatorio.setOnClickListener { onClickRelatorio() }
    }


    // configuração do navigation Drawer com a toolbar
    private fun configuraMenuLateral() {
        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(this, layoutMenuLateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    // método que deve ser implementado quando a activity implementa a interface NavigationView.OnNavigationItemSelectedListener
    // para tratar os eventos de clique no menu lateral
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {


            R.id.nav_perfil -> {
                Toast.makeText(this, "Clicou Mensagens", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_config -> {
                val intent = Intent(context, ConfiguracaoActivity::class.java)
                startActivityForResult(intent, 1)
            }

            R.id.nav_cliente -> {
                Toast.makeText(this, "Clicou client", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ListClienteActivity::class.java)
                startActivityForResult(intent, 1)

            }

            R.id.nav_caso -> {
                Toast.makeText(this, "Clicou caso", Toast.LENGTH_SHORT).show()

            }

            R.id.nav_sair -> {
                finish()
            }


        }

        // fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
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

        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}



