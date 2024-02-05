package com.estrelinha.cartaocredito.domain.repository;

import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import com.estrelinha.cartaocredito.infrastructure.repository.CartoesDbRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CartoesRepository extends CartoesDbRepository {
}
