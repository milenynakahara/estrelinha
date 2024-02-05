package com.estrelinha.cartaocredito.service.interfaces;

import com.estrelinha.cartaocredito.model.dto.CadastrarCartoesDtoModel;

import java.util.List;

public interface ProdutoInterface {
    String cadastrar(CadastrarCartoesDtoModel cadastrarCartoesDtoModel);
    List<CadastrarCartoesDtoModel> getCartoes(String produto, String categoria, String bandeira);
    String atualizarCartoes(String id, CadastrarCartoesDtoModel cadastrarCartoesDtoModel);
    String deletaCartao(String id);
}
