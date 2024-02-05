package com.estrelinha.cartaocredito.domain.Simulacao.model;

import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import jakarta.validation.constraints.NotBlank;

public record PegarCartoesDomainModel(
        @NotBlank
        String produto,
        String descricao,
        String taxa,
        @NotBlank
        String categoria,

        @NotBlank
        String bandeira) {

    public PegarCartoesDomainModel(CartoesModel dados) {
        this(
                dados.getProduto(),
                dados.getDescricao(),
                dados.getTaxa(),
                dados.getCategoria(),
                dados.getBandeira()
        );
    }
}
