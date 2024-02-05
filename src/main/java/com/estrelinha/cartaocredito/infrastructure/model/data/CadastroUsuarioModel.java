package com.estrelinha.cartaocredito.infrastructure.model.data;

import com.estrelinha.cartaocredito.domain.usuario.model.UsuarioDomainModel;
import com.estrelinha.cartaocredito.model.dto.UsuarioDtoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CadastroUsuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroUsuarioModel {
    @Id
    private String id;
    private String nome;
    private String cpf;

    private String dataDeNascimento;

    private String email;
    private String ddd;
    private String telefone;
    private String endereco;
    private String complemento;
    private String cep;
    private String bairro;
    private CartoesModel cartoesModels;

    public CadastroUsuarioModel(UsuarioDtoModel dados, CartoesModel cartoesModels) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.email = dados.email();
        this.ddd = dados.ddd();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
        this.complemento = dados.complemento();
        this.cep = dados.cep();
        this.bairro = dados.bairro();
        this.cartoesModels = cartoesModels;
    }

    public CadastroUsuarioModel(UsuarioDomainModel dados, CartoesModel cartoesModels) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.email = dados.email();
        this.ddd = dados.ddd();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
        this.complemento = dados.complemento();
        this.cep = dados.cep();
        this.bairro = dados.bairro();
        this.cartoesModels = cartoesModels;
    }

    public void atualizarCadastroUsuarioModel(UsuarioDomainModel dados, CartoesModel cartoesModels) {
        if (!dados.nome().isBlank())
            this.nome = dados.nome();

        if (!dados.cpf().isBlank())
            this.cpf = dados.cpf();

        if (!dados.dataDeNascimento().isBlank())
            this.dataDeNascimento = dados.dataDeNascimento();

        if (!dados.email().isBlank())
            this.email = dados.email();

        if (!dados.ddd().isBlank())
            this.ddd = dados.ddd();

        if (!dados.telefone().isBlank())
            this.telefone = dados.telefone();

        if (!dados.endereco().isBlank())
            this.endereco = dados.endereco();

        if (!dados.complemento().isBlank())
            this.complemento = dados.complemento();

        if (!dados.cep().isBlank())
            this.cep = dados.cep();

        if (!dados.bairro().isBlank())
            this.bairro = dados.bairro();

        if (cartoesModels != null)
            this.cartoesModels = cartoesModels;
    }
}
