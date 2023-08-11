package br.com.exaltasamba.enterprisechallenge.presentation.clienteFornecedor;

import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.Endereco;
import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.Telefone;

import java.util.List;

public record FormularioClienteFornecedor(String nome, String cpfCnpj, String email, Telefone telefone1, Telefone telefone2, Endereco endereco){}
