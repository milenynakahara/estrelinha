package com.estrelinha.cartaocredito.service;

import com.estrelinha.cartaocredito.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.model.dto.RetornoUsuarioDtoModel;
import com.estrelinha.cartaocredito.repository.CadastroRepository;
import com.estrelinha.cartaocredito.repository.CartoesRepository;
import com.estrelinha.cartaocredito.service.interfaces.UsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioInterface {
    @Autowired
    private CadastroRepository cadastroRepository;


    @Autowired
    private CartoesRepository cartoesRepository;
    @Override
    public void salvarUsuario(CadastroUsuarioModel cadastroUsuarioModel) {
        cadastroRepository.save(cadastroUsuarioModel);
    }

    @Override
    public RetornoUsuarioDtoModel buscarCadastro(String id) {
        System.out.println(cadastroRepository.findById(id).get());
        return cadastroRepository.findById(id).stream().map(RetornoUsuarioDtoModel::new).toList().get(0);
    }

    @Override
    public void atualizarUsuario(String id) {

    }

    @Override
    public void deletarUsuario(String id) {

    }
}
