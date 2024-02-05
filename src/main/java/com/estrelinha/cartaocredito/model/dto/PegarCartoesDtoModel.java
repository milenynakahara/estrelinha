package com.estrelinha.cartaocredito.model.dto;

import com.estrelinha.cartaocredito.domain.Simulacao.model.PegarCartoesDomainModel;
import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import jakarta.validation.constraints.NotBlank;

public record PegarCartoesDtoModel(
        @NotBlank
        String produto,
        String descricao,
        String taxa,
        @NotBlank
        String categoria,

        @NotBlank
        String bandeira) {

    public PegarCartoesDtoModel(CartoesModel dados) {
        this(
                dados.getProduto(),
                dados.getDescricao(),
                dados.getTaxa(),
                dados.getCategoria(),
                dados.getBandeira()
        );
    }

    public PegarCartoesDtoModel(PegarCartoesDomainModel dados) {
        this(
                dados.produto(),
                dados.descricao(),
                dados.taxa(),
                dados.categoria(),
                dados.bandeira()
        );
    }
}
