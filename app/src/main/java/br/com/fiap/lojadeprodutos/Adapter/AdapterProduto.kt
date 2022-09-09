package br.com.fiap.lojadeprodutos.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.lojadeprodutos.DetalheProdutoActivity
import br.com.fiap.lojadeprodutos.R
import br.com.fiap.lojadeprodutos.model.Produto
import com.squareup.picasso.Picasso


class AdapterProduto(private val context: Context, private val produtos: MutableList<Produto>): RecyclerView.Adapter<AdapterProduto.ProdutoViewHolder>() {

    //método responsável por criar as visualizações internas (itens da lista)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.produto_item, parent, false)
        val holder = ProdutoViewHolder(itemLista)
        return holder
    }
    //metodo responsável por exibir os itens
    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.descricao.text = produtos[position].descricao
        holder.valor.text = produtos[position].valor

        val imagemCelular = produtos[position].foto
        Picasso.with(context)
            .load("$imagemCelular")
            .resize(120, 120)
            .into(holder.foto)

        holder.foto.setOnClickListener {
            val intent = Intent(context, DetalheProdutoActivity::class.java)
            val descricao = produtos[position].descricao
            val valor = produtos[position].valor
            val especificacao = produtos[position].especificacao
            val foto = produtos[position].foto

            intent.putExtra("Descricao", "$descricao")
            intent.putExtra("Especificacao", "$especificacao")
            intent.putExtra("Valor", "$valor")
            intent.putExtra("Foto", "$foto")

            context.startActivity(intent)
        }
    }

    //tamanho da nossa lista
    override fun getItemCount(): Int = produtos.size

    inner class ProdutoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.image_view_foto_produto)
        val descricao = itemView.findViewById<TextView>(R.id.text_view_descricao_produto)
        val valor = itemView.findViewById<TextView>(R.id.text_view_preco_produto)
    }
}