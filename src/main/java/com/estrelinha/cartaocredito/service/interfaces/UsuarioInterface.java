package com.estrelinha.cartaocredito.service.interfaces;

import com.estrelinha.cartaocredito.model.dto.RetornoUsuarioDtoModel;
import com.estrelinha.cartaocredito.model.dto.UsuarioDtoModel;

public interface UsuarioInterface {
    String salvarUsuario(String produto, String categoria, String bandeira, UsuarioDtoModel usuarioDtoModel);
    RetornoUsuarioDtoModel buscarCadastro(String id);
    String atualizarUsuario(String produto, String categoria, String bandeira, UsuarioDtoModel usuarioDtoModel);
    String deletarUsuario(String documento);
}
