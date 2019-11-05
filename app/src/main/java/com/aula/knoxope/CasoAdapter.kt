package com.aula.knoxope

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso


// define o construtor que recebe a lista de disciplinas e o evento de clique
class CasoAdapter (
    val casos: List<Caso>,
    val onClick: (Caso) -> Unit): RecyclerView.Adapter<CasoAdapter.CasosViewHolder>() {

    // ViewHolder com os elemetos da tela
    class CasosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg: ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardAssunto)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_caso)
        }
    }

    // Quantidade de disciplinas na lista

    override fun getItemCount() = this.casos.size

    // inflar layout do adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasosViewHolder {
        // infla view no adapter
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_adapter_caso, parent, false)

        // retornar ViewHolder
        val holder = CasosViewHolder(view)
        return holder
    }

    // bind para atualizar Views com os dados

    override fun onBindViewHolder(holder: CasosViewHolder, position: Int) {
        val context = holder.itemView.context

        // recuperar objeto disciplina
        val caso = casos[position]

        // atualizar dados de disciplina

        holder.cardNome.text = caso.assunto
        holder.cardProgress.visibility = View.VISIBLE

        // download da imagem
        Picasso.with(context).load(caso.foto).fit().into(holder.cardImg,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })

        // adiciona evento de clique
        holder.itemView.setOnClickListener { onClick(caso) }
    }
}