package com.estrelinha.cartaocredito.domain.produto.service.interfaces;

import com.estrelinha.cartaocredito.domain.produto.model.CadastrarCartoesDomainModel;

import java.util.List;

public interface ProdutoDomainInterface {
    String cadastrar(CadastrarCartoesDomainModel cadastrarCartoesDomainModel);
    List<CadastrarCartoesDomainModel> getCartao(String produto, String categoria, String bandeira);
    String atualizarCartoes(String id, CadastrarCartoesDomainModel cadastrarCartoesDomainModel);
    String deletaCartoes(String id);
}
