package br.com.fiap.lojadeprodutos.util

//Esta funcao realiza a soma do valor dos itens acumulados
//no carrinho de compras e soma com o valor do último item adicionado ao carrinho,
//a fim de manter o valor total da compra sempre atualizado
fun calcularCompra(valorUltimaSoma: Double, valorProdutoAdicionado: Double): Double{
    val valorPedido = valorUltimaSoma + valorProdutoAdicionado
    return valorPedido
}
//Esta funcao realiza o desconto sobre o valor total da compra
fun aplicarDesconto(valorTotal: Double, desconto: Double): Double{
    val valorComDesconto = valorTotal - (valorTotal * (desconto/100))
    return valorComDesconto
}
//Esta funcao realiza o cálculo do valor das parcelas
fun CalcularValorParcelas(valorTotal:Double, numeroParcelas: Int): Double{
    val valorParcela = valorTotal/numeroParcelas
    return valorParcela
}