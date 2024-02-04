package com.estrelinha.cartaocredito.repository;

import com.estrelinha.cartaocredito.model.data.CartoesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartoesRepository extends MongoRepository<CartoesModel, String> {
    @Query("{'produto': ?0, 'categoria': ?1 ,'bandeira': ?2}")
    CartoesModel getCartoes(String produto, String categoria, String bandeira);

    @Query("{'produto': ?0}")
    CartoesModel getProduto(String produto);

    @Query("{'categoria': ?0}")
    CartoesModel getCategoria(String categoria);

    @Query("{'bandeira': ?0}")
    CartoesModel getBanceira(String bandeira);

}
