package br.com.exaltasamba.enterprisechallenge.domain.ordemVenda;

import br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor.ClienteFornecedorRepository;
import br.com.exaltasamba.enterprisechallenge.domain.produto.Produto;
import br.com.exaltasamba.enterprisechallenge.domain.produto.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdemVendaService {
    private final OrdemVendaRepository ordemVendaRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteFornecedorRepository clienteFornecedorRepository;

    public OrdemVendaService(OrdemVendaRepository ordemVendaRepository, ProdutoRepository produtoRepository, ClienteFornecedorRepository clienteFornecedorRepository) {
        this.ordemVendaRepository = ordemVendaRepository;
        this.produtoRepository = produtoRepository;
        this.clienteFornecedorRepository = clienteFornecedorRepository;
    }
    @Transactional
    public OrdemVenda cadastra(int idFornecedor, LocalDate dataEntrega, String logradouro, String numero, String bairro, String estado, String cep, List<DetalheOrdemVendaDto> detalhes) {
        var ordemVenda = new OrdemVenda(
                clienteFornecedorRepository.findById(idFornecedor).orElseThrow(),
                dataEntrega,
                logradouro,
                numero,
                bairro,
                estado,
                cep,
                detalhes.stream()
                        .map(it -> {
                            Produto produto = produtoRepository.findById(it.idProduto()).orElseThrow();
                            return new DetalheOrdemVenda(produto, it.quantidade(), it.desconto());
                        })
                        .toList()
        );
        ordemVendaRepository.save(ordemVenda);
        return ordemVenda;
    }

    @Transactional
    public void atualiza(int id, LocalDate dataEntrega, String logradouro, String numero, String bairro, String estado, String cep, List<DetalheOrdemVendaDto> detalhes) {
        var ordemVenda = ordemVendaRepository.findById(id).orElseThrow();
        ordemVenda.setDataEntrega(dataEntrega);
        ordemVenda.setLogradouro(logradouro);
        ordemVenda.setNumero(numero);
        ordemVenda.setBairro(bairro);
        ordemVenda.setEstado(estado);
        ordemVenda.setCep(cep);

        ordemVenda.getDetalhes().clear();
        ordemVenda.getDetalhes().addAll(detalhes.stream()
                .map(it -> {
                    Produto produto = produtoRepository.findById(it.idProduto()).orElseThrow();
                    return new DetalheOrdemVenda(produto, it.quantidade(), it.desconto());
                })
                .toList());
    }

    @Transactional
    public void deleta(int id){
        ordemVendaRepository.deleteById(id);
    }

}
