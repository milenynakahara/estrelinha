package com.estrelinha.cartaocredito.controller;

import com.estrelinha.cartaocredito.model.data.CadastroUsuarioModel;
import com.estrelinha.cartaocredito.model.data.CartoesModel;
import com.estrelinha.cartaocredito.model.dto.RetornoUsuarioDtoModel;
import com.estrelinha.cartaocredito.model.dto.UsuarioDtoModel;
import com.estrelinha.cartaocredito.repository.CadastroRepository;
import com.estrelinha.cartaocredito.repository.CartoesRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartao")
public class UsuarioController {
    @Autowired
    private CadastroRepository cadastroRepository;

    @Autowired
    private CartoesRepository cartoesRepository;

    @GetMapping("/simulacao")
    public CartoesModel simulacao(@Param("produto") String produto,
                                  @Param("categoria") String categoria,
                                  @Param("bandeira") String bandeira) {
        return cartoesRepository.getCartoes(produto, categoria, bandeira);
    }

    @PostMapping("/cadastro")
    @Transactional
    public String cadastrar(@Param("produto") String produto,
                            @Param("categoria") String categoria,
                            @Param("bandeira") String bandeira,
                            @RequestBody @Valid UsuarioDtoModel usuarioDtoModel) {
        CartoesModel cartoesModel = cartoesRepository.getCartoes(produto, categoria, bandeira);

        cadastroRepository.save(new CadastroUsuarioModel(usuarioDtoModel, cartoesModel));
        return "Contratação do cartão realizada com sucesso";
    }

    @GetMapping()
    public RetornoUsuarioDtoModel usuario(@Param("documento") String documento) {
        return new RetornoUsuarioDtoModel(cadastroRepository.getDocumento(documento));
    }


    @PutMapping()
    @Transactional
    public String atualizarCadastro(@Param("produto") String produto,
                                  @Param("categoria") String categoria,
                                  @Param("bandeira") String bandeira,
                                  @RequestBody @Valid UsuarioDtoModel usuarioDtoModel) {
        String retorno = "";

        try {
            CadastroUsuarioModel cadastro = cadastroRepository.getDocumento(usuarioDtoModel.cpf());
            CartoesModel cartoesModel = cartoesRepository.getCartoes(produto, categoria, bandeira);
            cadastro.atualizarCadastroUsuarioModel(usuarioDtoModel, cartoesModel);
            cadastroRepository.save(cadastro);
            retorno = "Usuário atualizado com sucesso";
        }catch (Exception e){
            retorno = "Usuário não encontrado";
        }

        return retorno;
    }
    @DeleteMapping
    @Transactional
    public String deletaCadastro(@Param("documento") String documento) {
        String retorno = "Cliente não encontrado";
        try {
            CadastroUsuarioModel cadastroUsuarioModel = cadastroRepository.getDocumento(documento);
            if (!cadastroUsuarioModel.getCpf().isBlank()) {
                cadastroRepository.delete(cadastroRepository.getId(cadastroUsuarioModel.getId()));
                retorno = "Cliente deletado com sucesso";
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return retorno;
    }
}
