package br.com.fiap.lojadeprodutos.service

import br.com.fiap.lojadeprodutos.model.Produto
import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList

interface RetrofitService {

    @GET("dd47e324-0109-48ec-b37a-675647fe1bb6")
    fun getProduto()  : Call<ArrayList<Produto>>
/*    fun getProduto(json: String)  : MutableList<ArrayList<Produto>> {
        val list = mutableListOf<ArrayList<Produto>>()
        var array = org.json.JSONArray(json)
        for (i in 0..array.length()-1)
        {
            val item = array.getJSONObject(i)
            val codigo = item.optString("codigo")
            val descricao = item.optString("decricao")
            val especificacao = item.optString("especificacao")
            val valor = item.optString("valor")
            val foto = item.optString("foto")
            val service = Produto(codigo, descricao, especificacao, valor, foto)
//            list.add(ArrayList<Produto>)
//           list.add(ArrayList<Produto>)

        }
        return list


    }
*/

}

