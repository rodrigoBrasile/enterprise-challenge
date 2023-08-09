package br.com.exaltasamba.enterprisechallenge.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final ClienteFornecedorRepository clienteFornecedorRepository;

    public MaterialService(MaterialRepository materialRepository, ClienteFornecedorRepository clienteFornecedorRepository) {
        this.materialRepository = materialRepository;
        this.clienteFornecedorRepository = clienteFornecedorRepository;
    }
    @Transactional
    public Material cadastra(int idFornecedor, String descricao, TipoUnidade unidade, BigDecimal custo, String codigoFabricante) {
        ClienteFornecedor clienteFornecedor = clienteFornecedorRepository.findById(idFornecedor).orElseThrow();
        var material = new Material(clienteFornecedor, descricao, unidade, custo, codigoFabricante);
        materialRepository.save(material);
        return material;
    }

    @Transactional
    public void atualiza(int id, String descricao, TipoUnidade unidade, BigDecimal custo, String codigoFabricante) {
        var material = materialRepository.findById(id).orElseThrow();
        material.setDescricao(descricao);
        material.setUnidade(unidade);
        material.setCusto(custo);
        material.setCodigoFabricante(codigoFabricante);
    }

    @Transactional
    public void deleta(int id){
        materialRepository.deleteById(id);
    }

}
