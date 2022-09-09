package br.com.fiap.lojadeprodutos.util

import org.junit.Assert.*

import org.junit.Test

class CalcularCarrinhoKtTest {

    @Test
    fun calcularCompra_carrinho_11200_item_adicionado_2500() {
        assertEquals(13700.00, calcularCompra(11200.00, 2500.00), 0.000001)
    }
    @Test
    fun aplicarDesconto_20_compra_2750() {
        assertEquals(2062.50, aplicarDesconto(2750.00, 25.0), 0.000001)
    }
    @Test
    fun calcularValorParcelas_compra_12425_parcelas_12() {
        assertEquals(1250.00, CalcularValorParcelas(12500.00, 10), 0.000001)
    }
}