package com.estrelinha.cartaocredito.repository;

import com.estrelinha.cartaocredito.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.model.data.CartoesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CadastroRepository extends MongoRepository<CadastroUsuarioModel, String> {
    @Query("{'cpf': ?0}")
    CadastroUsuarioModel getDocumento(String cpf);

    @Query("{'id': ?0}")
    CadastroUsuarioModel getId(String id);
}
