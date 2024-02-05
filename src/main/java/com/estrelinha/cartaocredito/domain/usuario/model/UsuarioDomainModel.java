package com.estrelinha.cartaocredito.domain.usuario.model;

import com.estrelinha.cartaocredito.model.dto.UsuarioDtoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDomainModel(
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
        String bairro) {

    public UsuarioDomainModel(UsuarioDtoModel dados) {
        this(
                dados.nome(),
                dados.cpf(),
                dados.dataDeNascimento(),
                dados.email(),
                dados.ddd(),
                dados.telefone(),
                dados.endereco(),
                dados.complemento(),
                dados.cep(),
                dados.bairro()
        );
    }
}
