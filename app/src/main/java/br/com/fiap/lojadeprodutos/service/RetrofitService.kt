package br.com.fiap.lojadeprodutos.service

import br.com.fiap.lojadeprodutos.model.Produto
import retrofit2.Call
import retrofit2.http.GET
import java.util.ArrayList

interface RetrofitService {

    @GET("caecbdc0-a035-4388-9d7b-9367e5fb5b07")
    fun getProduto()  : Call<ArrayList<Produto>>
}

