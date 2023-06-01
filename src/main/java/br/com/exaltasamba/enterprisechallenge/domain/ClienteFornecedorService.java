package br.com.exaltasamba.enterprisechallenge.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteFornecedorService {
    private final ClienteFornecedorRepository clienteFornecedorRepository;

    public ClienteFornecedorService(ClienteFornecedorRepository clienteFornecedorRepository) {
        this.clienteFornecedorRepository = clienteFornecedorRepository;
    }
    @Transactional
    public ClienteFornecedor cadastra(String nome, String documento, String email, List<Telefone> telefones, Endereco endereco) {
        var clienteFornecedor = new ClienteFornecedor(nome, documento, email, telefones, endereco);
        clienteFornecedorRepository.save(clienteFornecedor);
        return clienteFornecedor;
    }

    @Transactional
    public void atualiza(int id, String nome, String documento, String email, List<Telefone> telefones, Endereco endereco) {
        var clientefornecedor = clienteFornecedorRepository.findById(id).orElseThrow();
        clientefornecedor.setDocumento(documento);
        clientefornecedor.setEmail(email);
        clientefornecedor.setEndereco(endereco);
        clientefornecedor.setNome(nome);
        clientefornecedor.setTelefones(telefones);
    }

    @Transactional
    public void deleta(int id){
        clienteFornecedorRepository.deleteById(id);
    }

}
