package com.estrelinha.cartaocredito.domain.usuario.service.interfaces;

import com.estrelinha.cartaocredito.domain.usuario.model.RetornoUsuarioDomainModel;
import com.estrelinha.cartaocredito.domain.usuario.model.UsuarioDomainModel;

public interface UsuarioDomainInterface {
    String salvarUsuario(String produto, String categoria, String bandeira, UsuarioDomainModel usuarioDomainModel);
    RetornoUsuarioDomainModel buscarCadastro(String id);
    String atualizarUsuario(String produto, String categoria, String bandeira, UsuarioDomainModel usuarioDomainModel);
    String deletarUsuario(String documento);
}
