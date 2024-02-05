package com.estrelinha.cartaocredito.model.dto;

import com.estrelinha.cartaocredito.domain.produto.model.CadastrarCartoesDomainModel;
import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import jakarta.validation.constraints.NotBlank;

public record CadastrarCartoesDtoModel(

        String id,
        @NotBlank
        String produto,
        String descricao,
        String taxa,
        @NotBlank
        String categoria,

        @NotBlank
        String bandeira,
        @NotBlank
        String versao) {

    public CadastrarCartoesDtoModel(CartoesModel dados) {
        this(
                dados.getId(),
                dados.getProduto(),
                dados.getDescricao(),
                dados.getTaxa(),
                dados.getCategoria(),
                dados.getBandeira(),
                dados.getVersao()
        );
    }

    public CadastrarCartoesDtoModel(CadastrarCartoesDomainModel dados) {
        this(
                dados.id(),
                dados.produto(),
                dados.descricao(),
                dados.taxa(),
                dados.categoria(),
                dados.bandeira(),
                dados.versao()
        );
    }

    public CadastrarCartoesDtoModel(CadastrarCartoesDtoModel dados) {
        this(
                dados.id(),
                dados.produto(),
                dados.descricao(),
                dados.taxa(),
                dados.categoria(),
                dados.bandeira(),
                dados.versao()
        );
    }
}
