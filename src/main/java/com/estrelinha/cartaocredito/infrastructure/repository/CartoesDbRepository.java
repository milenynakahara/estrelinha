package com.estrelinha.cartaocredito.infrastructure.repository;

import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartoesDbRepository extends MongoRepository<CartoesModel, String> {
    @Query("{'produto': ?0, 'categoria': ?1 ,'bandeira': ?2}")
    CartoesModel getCartao(String produto, String categoria, String bandeira);

    @Query("{'produto': ?0, 'categoria': ?1 ,'bandeira': ?2}")
    List<CartoesModel>  getCartoes(String produto, String categoria, String bandeira);

    @Query("{'produto': ?0 }")
    List<CartoesModel> getAllProduto(String produto);

    @Query("{'categoria': ?0}")
    List<CartoesModel> getCategoria(String categoria);

    @Query("{'bandeira': ?0}")
    List<CartoesModel> getBandeira(String bandeira);

    @Query("{'id': ?0}")
    CartoesModel getId(String id);

}
