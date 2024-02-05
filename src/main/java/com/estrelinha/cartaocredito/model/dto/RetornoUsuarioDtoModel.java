package com.estrelinha.cartaocredito.model.dto;

import com.estrelinha.cartaocredito.domain.usuario.model.RetornoUsuarioDomainModel;
import com.estrelinha.cartaocredito.infrastructure.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RetornoUsuarioDtoModel(
        String id,
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{11,14}")
        String cpf,

        String dataDeNascimento,
        @NotBlank
        @Email
        String email,
        String ddd,
        String telefone,
        String endereco,
        String complemento,
        String cep,
        String bairro,
        CartoesModel cartoesModel) {

    public RetornoUsuarioDtoModel(CadastroUsuarioModel dados) {
        this(
                dados.getId(),
                dados.getNome(),
                dados.getCpf(),
                dados.getDataDeNascimento(),
                dados.getEmail(),
                dados.getDdd(),
                dados.getTelefone(),
                dados.getEndereco(),
                dados.getComplemento(),
                dados.getCep(),
                dados.getBairro(),
                dados.getCartoesModels());
    }

    public RetornoUsuarioDtoModel(RetornoUsuarioDomainModel dados) {
        this(
                dados.id(),
                dados.nome(),
                dados.cpf(),
                dados.dataDeNascimento(),
                dados.email(),
                dados.ddd(),
                dados.telefone(),
                dados.endereco(),
                dados.complemento(),
                dados.cep(),
                dados.bairro(),
                dados.cartoesModel());
    }
}
