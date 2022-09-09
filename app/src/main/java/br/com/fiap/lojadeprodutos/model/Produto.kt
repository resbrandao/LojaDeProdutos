package br.com.fiap.lojadeprodutos.model

import android.graphics.drawable.Drawable
import android.media.Image
import android.net.Uri
import android.widget.ImageView

/*data class Produto(

    val codigo: Int = 0,
    val descricao: String = "",
    val especificacao: String = "",
    val preco: String = "",
    val foto: Int


)

 */

import com.google.gson.annotations.SerializedName

data class Produto(

    @SerializedName("codigo") val codigo: String?,
    @SerializedName("descricao") val descricao: String?,
    @SerializedName("especificacao") val especificacao: String?,
    @SerializedName("valor") val valor: String?,
    @SerializedName("foto") val foto: String?


)