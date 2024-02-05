package com.estrelinha.cartaocredito.domain.Simulacao.service;

import com.estrelinha.cartaocredito.domain.Simulacao.model.PegarCartoesDomainModel;
import com.estrelinha.cartaocredito.domain.Simulacao.service.interfaces.SimulacaoDomainInterface;
import com.estrelinha.cartaocredito.infrastructure.repository.CartoesDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacaoDomainInterfaceImp implements SimulacaoDomainInterface {
    @Autowired
    CartoesDbRepository cartoesDbRepository;


    @Override
    public List<PegarCartoesDomainModel> getCartoes() {
        return cartoesDbRepository.findAll().stream()
                .map(PegarCartoesDomainModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PegarCartoesDomainModel> getProduto(String produto) {
        return cartoesDbRepository.getAllProduto(produto).stream()
                .map(PegarCartoesDomainModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PegarCartoesDomainModel> getBandeira(String bandeira) {
        return cartoesDbRepository.getBandeira(bandeira).stream()
                .map(PegarCartoesDomainModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<PegarCartoesDomainModel> getCategoria(String categoria) {
        return cartoesDbRepository.getCategoria(categoria).stream()
                .map(PegarCartoesDomainModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public PegarCartoesDomainModel getCartao(String produto, String categoria, String bandeira) {
        return new PegarCartoesDomainModel(cartoesDbRepository.getCartao(produto, categoria, bandeira));
    }
}
