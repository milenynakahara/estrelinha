package com.estrelinha.cartaocredito.domain.Simulacao.service.interfaces;

import com.estrelinha.cartaocredito.domain.Simulacao.model.PegarCartoesDomainModel;

import java.util.List;

public interface SimulacaoDomainInterface {
    List<PegarCartoesDomainModel>  getCartoes();
    List<PegarCartoesDomainModel> getProduto(String produto);
    List<PegarCartoesDomainModel> getBandeira(String bandeira);
    List<PegarCartoesDomainModel> getCategoria(String categoria);
    PegarCartoesDomainModel getCartao(String produto, String categoria, String bandeira);
}
