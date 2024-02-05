package com.estrelinha.cartaocredito.controller;

import com.estrelinha.cartaocredito.model.dto.RetornoUsuarioDtoModel;
import com.estrelinha.cartaocredito.model.dto.UsuarioDtoModel;
import com.estrelinha.cartaocredito.service.UsuarioServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImp usuarioServiceImp;


    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<String> cadastrar(@Param("produto") String produto,
                                            @Param("categoria") String categoria,
                                            @Param("bandeira") String bandeira,
                                            @RequestBody @Valid UsuarioDtoModel usuarioDtoModel) {

        return ResponseEntity.ok(usuarioServiceImp.salvarUsuario(produto, categoria, bandeira, usuarioDtoModel));
    }

    @GetMapping()
    public ResponseEntity<RetornoUsuarioDtoModel> usuario(@Param("documento") String documento) {
        return ResponseEntity.ok(usuarioServiceImp.buscarCadastro(documento));
    }


    @PutMapping()
    @Transactional
    public ResponseEntity<String> atualizarCadastro(@Param("produto") String produto,
                                    @Param("categoria") String categoria,
                                    @Param("bandeira") String bandeira,
                                    @RequestBody @Valid UsuarioDtoModel usuarioDtoModel) {

        return ResponseEntity.ok(usuarioServiceImp.atualizarUsuario(produto, categoria, bandeira, usuarioDtoModel));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> deletaCadastro(@Param("documento") String documento) {
        return ResponseEntity.ok(usuarioServiceImp.deletarUsuario(documento));
    }
}
