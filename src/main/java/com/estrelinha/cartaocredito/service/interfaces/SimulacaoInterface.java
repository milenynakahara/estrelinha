package com.estrelinha.cartaocredito.service.interfaces;

import com.estrelinha.cartaocredito.model.dto.PegarCartoesDtoModel;

import java.util.List;

public interface SimulacaoInterface {
    List<PegarCartoesDtoModel>  getCartoes();
    List<PegarCartoesDtoModel> getProduto(String produto);
    List<PegarCartoesDtoModel> getBandeira(String bandeira);
    List<PegarCartoesDtoModel> getCategoria(String categoria);
    PegarCartoesDtoModel getCartao(String produto, String categoria, String bandeira);
}
