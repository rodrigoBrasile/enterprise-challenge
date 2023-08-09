package br.com.exaltasamba.enterprisechallenge.presentation.produto;

import br.com.exaltasamba.enterprisechallenge.domain.produto.DetalheProdutoDto;

import java.math.BigDecimal;
import java.util.List;

public record FormularioProduto(String descricao, BigDecimal preco, List<DetalheProdutoDto> detalhes){}

