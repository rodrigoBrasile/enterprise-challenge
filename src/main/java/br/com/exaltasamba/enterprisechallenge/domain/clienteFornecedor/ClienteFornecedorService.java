package br.com.exaltasamba.enterprisechallenge.domain.clienteFornecedor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteFornecedorService {
    private final ClienteFornecedorRepository clienteFornecedorRepository;

    public ClienteFornecedorService(ClienteFornecedorRepository clienteFornecedorRepository) {
        this.clienteFornecedorRepository = clienteFornecedorRepository;
    }
    @Transactional
    public ClienteFornecedor cadastra(String nome, String cpfCnpj, String email, Telefone telefone1, Telefone telefone2, Endereco endereco) {
        var clienteFornecedor = new ClienteFornecedor(nome, cpfCnpj, email, telefone1, telefone2, endereco);
        clienteFornecedorRepository.save(clienteFornecedor);
        return clienteFornecedor;
    }

    @Transactional
    public void atualiza(int id, String nome, String documento, String email, Telefone telefone1, Telefone telefone2, Endereco endereco) {
        var clientefornecedor = clienteFornecedorRepository.findById(id).orElseThrow();
        clientefornecedor.setCpfCnpj(documento);
        clientefornecedor.setEmail(email);
        clientefornecedor.setEndereco(endereco);
        clientefornecedor.setNome(nome);
        clientefornecedor.setTelefone1(telefone1);
        clientefornecedor.setTelefone2(telefone2);
    }

    @Transactional
    public void deleta(int id){
        clienteFornecedorRepository.deleteById(id);
    }

}
