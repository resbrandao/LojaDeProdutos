package br.com.fiap.lojadeprodutos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.lojadeprodutos.Adapter.AdapterProduto
import br.com.fiap.lojadeprodutos.model.Produto
import br.com.fiap.lojadeprodutos.retrofit.retrofitProdutoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ListaProdutosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        val recyclerView_produtos = findViewById<RecyclerView>(R.id.recyclerView_produtos)
        recyclerView_produtos.layoutManager = GridLayoutManager(this, 2)

        recyclerView_produtos.setHasFixedSize(true)

        val listaProdutos: MutableList<Produto> = mutableListOf()
        val contexto = this

        val call = retrofitProdutoService().getProduto()

        call.enqueue(object : Callback<ArrayList<Produto>> {
            override fun onResponse(call: Call<ArrayList<Produto>>, response: Response<ArrayList<Produto>>) {
                Log.i("xpto", "Código HTTP: ${response.code().toString()}")
                Log.i("xpto", response.body().toString())
                Log.i("xpto", response.body()?.size.toString())

                val size = response.body()?.size.toString()
                val sizeInt = size.toInt()

                var produtoLista = Produto(null, null, null, null, null)

                for(i in 0..sizeInt-1) {
                    produtoLista = response.body()?.get(i)?.let {
                        Produto(
                            codigo = it.codigo,
                            descricao = it.descricao,
                            especificacao = it.especificacao,
                            valor = it.valor,
                            foto = it.foto
                        )
                    }!!

                    listaProdutos.add(produtoLista)
                }

                val adapterProduto = AdapterProduto(contexto, listaProdutos)
                recyclerView_produtos.adapter = adapterProduto

                if (response.code().toInt() == 401) {
                    Toast.makeText(
                        applicationContext,
                        "Produto invalido",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

                if (response.code().toInt() == 404) {
                    Toast.makeText(
                        applicationContext,
                        "Produto não encontrado",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
            }

            override fun onFailure(call: Call<ArrayList<Produto>>, t: Throwable?) {
                if (t != null) {
                    Log.i("xpto", "Erro Produto ${t.message.toString()}")
                }

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.samsung -> {
                Log.d("samsung", "exibir aparelhos Samsung")
                val intent = Intent(this, ListaProdutosActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
