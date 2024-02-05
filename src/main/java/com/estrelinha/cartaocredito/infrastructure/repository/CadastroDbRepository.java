package com.estrelinha.cartaocredito.infrastructure.repository;

import com.estrelinha.cartaocredito.infrastructure.model.data.CadastroUsuarioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CadastroDbRepository extends MongoRepository<CadastroUsuarioModel, String> {
    @Query("{'cpf': ?0}")
    CadastroUsuarioModel getDocumento(String cpf);

    @Query("{'id': ?0}")
    CadastroUsuarioModel getId(String id);
}
