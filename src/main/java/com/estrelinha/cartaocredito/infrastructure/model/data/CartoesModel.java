package com.estrelinha.cartaocredito.infrastructure.model.data;

import com.estrelinha.cartaocredito.domain.produto.model.CadastrarCartoesDomainModel;
import com.estrelinha.cartaocredito.model.dto.CadastrarCartoesDtoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "cartoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartoesModel implements Serializable {
    @Id
    private String id;

    private String produto;

    private String descricao;

    private String taxa;

    private String categoria;

    private String bandeira;

    private String versao;

    public CartoesModel(CadastrarCartoesDtoModel dados) {
        this.produto = dados.produto();
        this.descricao = dados.descricao();
        this.taxa = dados.taxa();
        this.categoria = dados.categoria();
        this.bandeira = dados.bandeira();
        this.versao = dados.versao();
    }

    public CartoesModel(CadastrarCartoesDomainModel dados) {
        this.produto = dados.produto();
        this.descricao = dados.descricao();
        this.taxa = dados.taxa();
        this.categoria = dados.categoria();
        this.bandeira = dados.bandeira();
        this.versao = dados.versao();
    }

    public void atualizarCartoesModel(CadastrarCartoesDtoModel dados) {
        if (!dados.produto().isBlank())
            this.produto = dados.produto();

        if (!dados.descricao().isBlank())
            this.descricao = dados.descricao();

        if (!dados.taxa().isBlank())
            this.taxa = dados.taxa();

        if (!dados.categoria().isBlank())
            this.categoria = dados.categoria();

        if (!dados.bandeira().isBlank())
            this.bandeira = dados.bandeira();

        if (!dados.versao().isBlank())
            this.versao = dados.versao();
    }

    public void atualizarCartoesModel(CadastrarCartoesDomainModel dados) {
        if (!dados.produto().isBlank())
            this.produto = dados.produto();

        if (!dados.descricao().isBlank())
            this.descricao = dados.descricao();

        if (!dados.taxa().isBlank())
            this.taxa = dados.taxa();

        if (!dados.categoria().isBlank())
            this.categoria = dados.categoria();

        if (!dados.bandeira().isBlank())
            this.bandeira = dados.bandeira();

        if (!dados.versao().isBlank())
            this.versao = dados.versao();
    }
}