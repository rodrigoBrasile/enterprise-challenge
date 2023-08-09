package br.com.exaltasamba.enterprisechallenge.presentation.material;

import br.com.exaltasamba.enterprisechallenge.domain.TipoUnidade;

import java.math.BigDecimal;

public record FormularioMaterial(int idFornecedor, String descricao, TipoUnidade unidade, BigDecimal custo, String codigoFabricante){}
