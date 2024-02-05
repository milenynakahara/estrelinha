package com.estrelinha.cartaocredito.domain.produto.model;

import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import com.estrelinha.cartaocredito.model.dto.CadastrarCartoesDtoModel;
import jakarta.validation.constraints.NotBlank;

public record CadastrarCartoesDomainModel(

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

    public CadastrarCartoesDomainModel(CartoesModel dados) {
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

    public CadastrarCartoesDomainModel(CadastrarCartoesDtoModel dados) {
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
