package com.estrelinha.cartaocredito.service;

import com.estrelinha.cartaocredito.domain.produto.model.CadastrarCartoesDomainModel;
import com.estrelinha.cartaocredito.domain.produto.service.ProdutoDomainInterfaceImp;
import com.estrelinha.cartaocredito.model.dto.CadastrarCartoesDtoModel;
import com.estrelinha.cartaocredito.service.interfaces.ProdutoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImp implements ProdutoInterface {
    @Autowired
    private ProdutoDomainInterfaceImp produtoDomainInterface;

    @Override
    public String cadastrar(CadastrarCartoesDtoModel cadastrarCartoesDtoModel) {
        return produtoDomainInterface.cadastrar(new CadastrarCartoesDomainModel(cadastrarCartoesDtoModel));
    }

    @Override
    public List<CadastrarCartoesDtoModel> getCartoes(String produto, String categoria, String bandeira) {
        return produtoDomainInterface.getCartao(produto, categoria, bandeira).stream()
                .map(CadastrarCartoesDtoModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public String atualizarCartoes(String id, CadastrarCartoesDtoModel cadastrarCartoesDtoModel) {
        return produtoDomainInterface.atualizarCartoes(id, new CadastrarCartoesDomainModel(cadastrarCartoesDtoModel));
    }

    @Override
    public String deletaCartao(String id) {
        return produtoDomainInterface.deletaCartoes(id);
    }
}
