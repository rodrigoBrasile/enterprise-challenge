package br.com.exaltasamba.enterprisechallenge.domain.produto;

import br.com.exaltasamba.enterprisechallenge.domain.material.Material;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class DetalheProduto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne @JoinColumn(name="id_material")
    private Material material;

    private BigDecimal quantidade;

    public DetalheProduto(Material material, BigDecimal quantidade) {
        this.material = material;
        this.quantidade = quantidade;
    }

    public DetalheProduto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
}
