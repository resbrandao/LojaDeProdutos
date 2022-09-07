package br.com.fiap.lojadeprodutos.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.lojadeprodutos.DetalheProdutoActivity
import br.com.fiap.lojadeprodutos.R
import br.com.fiap.lojadeprodutos.model.Produto
import android.content.Intent as Intent

class AdapterProduto(private val context: Context, private val produtos: MutableList<Produto>): RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {

    //método responsável por criar as visualizações internas (itens da lista)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.produto_item, parent, false)
        val holder = ProdutoViewHolder(itemLista)
        return holder
    }
    //metodo responsável por exibir os itens
    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
 //       holder.foto.setImageResource(produtos[position].foto)
        holder.descricao.text = produtos[position].descricao
        holder.preco.text = produtos[position].preco

        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, DetalheProdutoActivity::class.java))
        }
    }
    
    //tamanho da nossa lista
    override fun getItemCount(): Int = produtos.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.fotoProduto)
        val descricao = itemView.findViewById<TextView>(R.id.nomeProduto)
        val preco = itemView.findViewById<TextView>(R.id.precoProduto)
    }

}