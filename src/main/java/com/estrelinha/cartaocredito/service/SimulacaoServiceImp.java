package com.estrelinha.cartaocredito.service;

import com.estrelinha.cartaocredito.domain.Simulacao.service.interfaces.SimulacaoDomainInterface;
import com.estrelinha.cartaocredito.domain.produto.model.CadastrarCartoesDomainModel;
import com.estrelinha.cartaocredito.domain.produto.service.ProdutoDomainInterfaceImp;
import com.estrelinha.cartaocredito.model.dto.CadastrarCartoesDtoModel;
import com.estrelinha.cartaocredito.model.dto.PegarCartoesDtoModel;
import com.estrelinha.cartaocredito.service.interfaces.ProdutoInterface;
import com.estrelinha.cartaocredito.service.interfaces.SimulacaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacaoServiceImp implements SimulacaoInterface {
    @Autowired
    private SimulacaoDomainInterface produtoDomainInterface;


    @Override
    public List<PegarCartoesDtoModel> getCartoes() {
        return produtoDomainInterface.getCartoes().stream()
                .map(PegarCartoesDtoModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PegarCartoesDtoModel> getProduto(String produto) {
        return produtoDomainInterface.getProduto(produto).stream()
                .map(PegarCartoesDtoModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PegarCartoesDtoModel> getBandeira(String bandeira) {
        return produtoDomainInterface.getBandeira(bandeira).stream()
                .map(PegarCartoesDtoModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PegarCartoesDtoModel> getCategoria(String categoria) {
        return produtoDomainInterface.getCategoria(categoria).stream()
                .map(PegarCartoesDtoModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public PegarCartoesDtoModel getCartao(String produto, String categoria, String bandeira) {
        return new PegarCartoesDtoModel(produtoDomainInterface.getCartao(produto, categoria, bandeira));
    }
}
