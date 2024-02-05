package com.estrelinha.cartaocredito.service;

import com.estrelinha.cartaocredito.domain.usuario.model.UsuarioDomainModel;
import com.estrelinha.cartaocredito.domain.usuario.service.interfaces.UsuarioDomainInterface;
import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import com.estrelinha.cartaocredito.infrastructure.repository.CartoesDbRepository;
import com.estrelinha.cartaocredito.model.dto.RetornoUsuarioDtoModel;
import com.estrelinha.cartaocredito.model.dto.UsuarioDtoModel;
import com.estrelinha.cartaocredito.service.interfaces.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioInterface {
    @Autowired
    private UsuarioDomainInterface usuarioDomainInterface;

    @Autowired
    private CartoesDbRepository cartoesDbRepository;

    @Override
    public String salvarUsuario(String produto, String categoria, String bandeira, UsuarioDtoModel usuarioDtoModel) {
        CartoesModel cartoesModel = cartoesDbRepository.getCartao(produto, categoria, bandeira);

        return usuarioDomainInterface.salvarUsuario(produto, categoria, bandeira, new UsuarioDomainModel(usuarioDtoModel));
    }

    @Override
    public RetornoUsuarioDtoModel buscarCadastro( String documento) {
        return new RetornoUsuarioDtoModel(usuarioDomainInterface.buscarCadastro(documento));
    }

    @Override
    public String atualizarUsuario(String produto,
                                   String categoria,
                                   String bandeira,
                                   UsuarioDtoModel usuarioDtoModel) {
        return usuarioDomainInterface.atualizarUsuario(produto, categoria, bandeira, new UsuarioDomainModel(usuarioDtoModel));
    }

    @Override
    public String deletarUsuario(String documento) {
        return usuarioDomainInterface.deletarUsuario(documento);
    }
}
