package br.com.fiap.lojadeprodutos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class DetalheProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_produto)

        val dadosProduto = intent.extras
        val descricaoProduto = dadosProduto?.getString("Descricao")
        val especificacaoProduto = dadosProduto?.getString("Especificacao")
        val valorProduto = dadosProduto?.getString("Valor")
        val foto = dadosProduto?.getString("Foto")

        val descricao = findViewById<TextView>(R.id.text_view_descricao)
        val especificacao = findViewById<TextView>(R.id.text_view_especificacao)
        val valor = findViewById<TextView>(R.id.text_view_valor)
        val imagemCelular = findViewById<ImageView>(R.id.image_view_foto_produto_selecionado)
        Picasso.with(this)
            .load("$foto")
            .resize(500, 500)
            .into(imagemCelular)

        descricao.text = descricaoProduto
        especificacao.text = especificacaoProduto
        valor.text = valorProduto
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