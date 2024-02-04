package com.estrelinha.cartaocredito.model.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "cartoes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartoesModel implements Serializable {
    @Id
    private String id;

    private String produto;

    private String descricao;

    private String taxa;

    private String categoria;

    private String bandeira;

    private String versao;
}