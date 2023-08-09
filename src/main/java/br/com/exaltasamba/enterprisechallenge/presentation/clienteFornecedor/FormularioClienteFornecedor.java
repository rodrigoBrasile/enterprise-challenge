package br.com.exaltasamba.enterprisechallenge.presentation.clienteFornecedor;

import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.Endereco;
import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.Telefone;

import java.util.List;

public record FormularioClienteFornecedor(String nome, String documento, String email, List<Telefone> telefones, Endereco endereco){}
