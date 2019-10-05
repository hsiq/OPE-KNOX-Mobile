package com.aula.knoxope

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class Perfil : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        var toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Meu Perfil"

        configuraMenuLateral()

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
                val intent = Intent(context, Perfil::class.java)
                startActivityForResult(intent, 1)
            }

            R.id.nav_config -> {
                val intent = Intent(context, ConfiguracaoActivity::class.java)
                startActivityForResult(intent, 1)
            }

            R.id.nav_cliente -> {
                val intent = Intent(context, ListClienteActivity::class.java)
                startActivityForResult(intent, 1)

            }

            R.id.nav_caso -> {
                val intent = Intent(context, ListCasoActivity::class.java)
                startActivityForResult(intent, 1)
            }

            R.id.nav_sair -> {
                finish()
            }


        }

        // fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }






}



