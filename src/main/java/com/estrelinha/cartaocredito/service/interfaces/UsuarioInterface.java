package com.estrelinha.cartaocredito.service.interfaces;

import com.estrelinha.cartaocredito.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.model.dto.RetornoUsuarioDtoModel;

public interface UsuarioInterface {
    void salvarUsuario(CadastroUsuarioModel cadastroUsuarioModel);
    RetornoUsuarioDtoModel buscarCadastro(String id);
    void atualizarUsuario(String id);
    void deletarUsuario(String id);
}
