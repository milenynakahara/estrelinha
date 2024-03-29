package com.estrelinha.cartaocredito.model.dto;

import com.estrelinha.cartaocredito.domain.usuario.model.UsuarioDomainModel;
import com.estrelinha.cartaocredito.infrastructure.model.data.CadastroUsuarioModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDtoModel(
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

    public UsuarioDtoModel(CadastroUsuarioModel cadastroUsuarioModel) {
        this(
                cadastroUsuarioModel.getNome(),
                cadastroUsuarioModel.getCpf(),
                cadastroUsuarioModel.getDataDeNascimento(),
                cadastroUsuarioModel.getEmail(),
                cadastroUsuarioModel.getDdd(),
                cadastroUsuarioModel.getTelefone(),
                cadastroUsuarioModel.getEndereco(),
                cadastroUsuarioModel.getComplemento(),
                cadastroUsuarioModel.getCep(),
                cadastroUsuarioModel.getBairro()
        );
    }

    public UsuarioDtoModel(UsuarioDomainModel dados) {
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
