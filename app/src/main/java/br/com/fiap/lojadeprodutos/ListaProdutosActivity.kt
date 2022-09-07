package br.com.fiap.lojadeprodutos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.lojadeprodutos.Adapter.AdapterProduto
import br.com.fiap.lojadeprodutos.model.Produto
import br.com.fiap.lojadeprodutos.retrofit.retrofitProdutoService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL
import java.util.ArrayList

class ListaProdutosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_produtos)

        val recyclerView_produtos = findViewById<RecyclerView>(R.id.recyclerView_produtos)
        recyclerView_produtos.layoutManager = GridLayoutManager(this, 2)
//            LinearLayoutManager(this)
        recyclerView_produtos.setHasFixedSize(true)
        //Configurar o adapter

        val listaProdutos: MutableList<Produto> = mutableListOf()
        val adapterProduto = AdapterProduto(this, listaProdutos)
        recyclerView_produtos.adapter = adapterProduto
/*
        val produto1 = Produto(
            "1",
            "Samsung Galaxy S10+",
            "Samsung Galaxy S10+, Preto,512GB, Tela 6.4,Câm. Tripla 12MP",
            "R$ 2799,00",
            R.drawable.samsung1
        )
        listaProdutos.add(produto1)

        val produto2 = Produto(
            "2",
            "Samsung Galaxy S21 Ultra",
            "Samsung Galaxy S21 Ultra 5G SM-G998B 512GB Android",
            "R$ 5999,00",
            R.drawable.samsung2
        )
        listaProdutos.add(produto2)

        val produto3 = Produto(
            "3",
            "Samsung Galaxy Z Flip3",
            "Samsung Galaxy Z Flip3 5G SM-F711BZ 128GB Android",
            "R$ 5599,00",
            R.drawable.samsung3
        )
        listaProdutos.add(produto3)

        val produto4 = Produto(
            "4",
            "Samsung Galaxy S20 FE",
            "Samsung Galaxy S20 FE 128GB",
            "R$ 2376,00",
            R.drawable.samsung4
        )
        listaProdutos.add(produto4)

        val produto5 = Produto(
            "5",
            "Samsung Galaxy SZ Fold3 5G 256GB",
            "Samsung Galaxy SZ Fold3 5G 256GB",
            "R$ 11790,90",
            R.drawable.samsung5
        )
        listaProdutos.add(produto5)

        val produto6 = Produto(
            "6",
            "Samsung Galaxy Z Flip3",
            "Samsung Galaxy Z Flip3 5G SM-F711BZ 128GB Android",
            "R$ 5599,00",
            R.drawable.samsung6
        )
        listaProdutos.add(produto6)

*/
        val call = retrofitProdutoService().getProduto()

        call.enqueue(object : Callback<ArrayList<Produto>> {

            override fun onResponse(call: Call<ArrayList<Produto>>, response: Response<ArrayList<Produto>>) {
                Log.i("xpto", "Código HTTP: ${response.code().toString()}")
                Log.i("xpto", response.body().toString())

 /*               fun getServicesFromGSON(json: String): List<Produto>{
                    val type = object: TypeToken<List<Produto>>(){}.type
                    return Gson().fromJson<List<Produto>>(json, type)
                }


                fun downloadJSON(): String{
                    return URL("https://run.mocky.io/v3/993e9761-c618-4706-9674-06e07fdc3d73").readText();
                }

                fun main(args: Array<String>) {
                    var json = downloadJSON()

                    val list1 = getServices(json)
                    for (item in list1) {
                        println("${item.codigo} - ${item.descricao}")
                    }

                    val list2 = getServicesFromGSON(json)
                    for (item in list2) {
                        println("${item.codigo} - ${item.descricao}")
                    }
                }
*/


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
}
