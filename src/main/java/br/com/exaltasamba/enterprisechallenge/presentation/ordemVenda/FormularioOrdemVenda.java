package br.com.exaltasamba.enterprisechallenge.presentation.ordemVenda;

import br.com.exaltasamba.enterprisechallenge.domain.ordemVenda.DetalheOrdemVendaDto;

import java.time.LocalDate;
import java.util.List;

public record FormularioOrdemVenda(int idCliente, LocalDate dataEntrega, String logradouro, String numero, String bairro, String estado, String cep, String informacoesAdicionais, List<DetalheOrdemVendaDto> detalhes) {}
