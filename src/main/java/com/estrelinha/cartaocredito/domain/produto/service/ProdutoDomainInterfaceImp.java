package com.estrelinha.cartaocredito.domain.produto.service;

import com.estrelinha.cartaocredito.domain.produto.model.CadastrarCartoesDomainModel;
import com.estrelinha.cartaocredito.domain.produto.service.interfaces.ProdutoDomainInterface;
import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import com.estrelinha.cartaocredito.infrastructure.repository.CartoesDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoDomainInterfaceImp implements ProdutoDomainInterface {
    @Autowired
    CartoesDbRepository cartoesDbRepository;

    @Override
    public String cadastrar(CadastrarCartoesDomainModel cadastrarCartoesDomainModel) {
        cartoesDbRepository.save(new CartoesModel(cadastrarCartoesDomainModel));
        return "Produto salvo com sucesso";
    }

    @Override
    public List<CadastrarCartoesDomainModel> getCartao(String produto, String categoria, String bandeira) {
        return cartoesDbRepository.getCartoes(produto, categoria, bandeira).stream()
                .map(CadastrarCartoesDomainModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public String atualizarCartoes(String id, CadastrarCartoesDomainModel cadastrarCartoesDomainModel) {
        String retorno = "";

        try {
            CartoesModel cartoesModel = cartoesDbRepository.getId(id);
            cartoesModel.atualizarCartoesModel(cadastrarCartoesDomainModel);
            cartoesDbRepository.save(cartoesModel);
            retorno = "Cartão Atualizado com sucesso";
        }catch (Exception e){
            retorno = "Cartão não encontrado";
        }

        return retorno;
    }

    @Override
    public String deletaCartoes(String id) {
        String retorno = "Cliente não encontrado";
        try {
            CartoesModel cartoesModel = cartoesDbRepository.getId(id);
            if (!cartoesModel.getId().isBlank()) {
                cartoesDbRepository.delete(cartoesModel);
                retorno = "Cliente deletado com sucesso";
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return retorno;
    }
}
