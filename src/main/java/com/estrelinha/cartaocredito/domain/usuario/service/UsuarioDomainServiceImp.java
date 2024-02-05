package com.estrelinha.cartaocredito.domain.usuario.service;

import com.estrelinha.cartaocredito.domain.repository.CartoesRepository;
import com.estrelinha.cartaocredito.domain.usuario.model.RetornoUsuarioDomainModel;
import com.estrelinha.cartaocredito.domain.usuario.model.UsuarioDomainModel;
import com.estrelinha.cartaocredito.domain.usuario.service.interfaces.UsuarioDomainInterface;
import com.estrelinha.cartaocredito.infrastructure.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.infrastructure.model.data.CartoesModel;
import com.estrelinha.cartaocredito.infrastructure.repository.CadastroDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDomainServiceImp implements UsuarioDomainInterface {
    @Autowired
    private CadastroDbRepository cadastroDbRepository;

    @Autowired
    private CartoesRepository cartoesDbRepository;

    @Override
    public String salvarUsuario(String produto, String categoria, String bandeira, UsuarioDomainModel usuarioDomainModel) {
        CartoesModel cartoesModel = cartoesDbRepository.getCartao(produto, categoria, bandeira);

        cadastroDbRepository.save(new CadastroUsuarioModel(usuarioDomainModel, cartoesModel));
        return "Contratação do cartão realizada com sucesso";
    }

    @Override
    public RetornoUsuarioDomainModel buscarCadastro(String documento) {
        return new RetornoUsuarioDomainModel(cadastroDbRepository.getDocumento(documento));
    }

    @Override
    public String atualizarUsuario(String produto,
                                   String categoria,
                                   String bandeira,
                                   UsuarioDomainModel usuarioDomainModel) {
        String retorno = "";
        try {
            CadastroUsuarioModel cadastro = cadastroDbRepository.getDocumento(usuarioDomainModel.cpf());
            CartoesModel cartoesModel = cartoesDbRepository.getCartao(produto, categoria, bandeira);
            cadastro.atualizarCadastroUsuarioModel(usuarioDomainModel, cartoesModel);
            cadastroDbRepository.save(cadastro);
            retorno = "Usuário atualizado com sucesso";
        }catch (Exception e){
            retorno = "Usuário não encontrado";
        }

        return retorno;

    }

    @Override
    public String deletarUsuario(String documento) {
        String retorno = "Cliente não encontrado";
        try {
            CadastroUsuarioModel cadastroUsuarioModel = cadastroDbRepository.getDocumento(documento);
            if (!cadastroUsuarioModel.getCpf().isBlank()) {
                cadastroDbRepository.delete(cadastroDbRepository.getId(cadastroUsuarioModel.getId()));
                retorno = "Cliente deletado com sucesso";
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return retorno;
    }
}
