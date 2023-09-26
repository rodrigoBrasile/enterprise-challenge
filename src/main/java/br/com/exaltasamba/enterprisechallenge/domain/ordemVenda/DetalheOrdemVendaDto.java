package br.com.exaltasamba.enterprisechallenge.domain.ordemVenda;

import java.math.BigDecimal;

public record DetalheOrdemVendaDto(int idProduto, BigDecimal quantidade, BigDecimal desconto) {
}
