package com.estrelinha.cartaocredito.model.dto;

import com.estrelinha.cartaocredito.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.model.data.CartoesModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    public RetornoUsuarioDtoModel(CadastroUsuarioModel cadastroUsuarioModel) {
        this(
                cadastroUsuarioModel.getId(),
                cadastroUsuarioModel.getNome(),
                cadastroUsuarioModel.getCpf(),
                cadastroUsuarioModel.getDataDeNascimento(),
                cadastroUsuarioModel.getEmail(),
                cadastroUsuarioModel.getDdd(),
                cadastroUsuarioModel.getTelefone(),
                cadastroUsuarioModel.getEndereco(),
                cadastroUsuarioModel.getComplemento(),
                cadastroUsuarioModel.getCep(),
                cadastroUsuarioModel.getBairro(),
                cadastroUsuarioModel.getCartoesModels());
    }
}
