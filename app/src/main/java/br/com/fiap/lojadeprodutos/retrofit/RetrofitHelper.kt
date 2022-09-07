package br.com.fiap.lojadeprodutos.retrofit

import br.com.fiap.lojadeprodutos.service.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://run.mocky.io/v3/"

fun getRetrofitFactory() =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun retrofitProdutoService(): RetrofitService =
    getRetrofitFactory()
        .create(RetrofitService::class.java)