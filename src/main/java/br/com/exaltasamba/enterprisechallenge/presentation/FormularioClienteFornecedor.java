package br.com.exaltasamba.enterprisechallenge.presentation;

import br.com.exaltasamba.enterprisechallenge.domain.Endereco;
import br.com.exaltasamba.enterprisechallenge.domain.Telefone;

import java.util.List;

public record FormularioClienteFornecedor(String nome, String documento, String email, List<Telefone> telefones, Endereco endereco){}
