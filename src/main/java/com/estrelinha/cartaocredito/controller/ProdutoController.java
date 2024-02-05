package com.estrelinha.cartaocredito.controller;

import com.estrelinha.cartaocredito.model.dto.CadastrarCartoesDtoModel;
import com.estrelinha.cartaocredito.service.interfaces.ProdutoInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoInterface produtoInterface;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarCartoesDtoModel cadastrarCartoesDtoModel) {
        return ResponseEntity.ok(produtoInterface.cadastrar(cadastrarCartoesDtoModel));
    }

    @GetMapping("/cartao")
    public ResponseEntity<List<CadastrarCartoesDtoModel>> getCartao(@Param("produto") String produto,
                                                @Param("categoria") String categoria,
                                                @Param("bandeira") String bandeira) {
        return ResponseEntity.ok(produtoInterface.getCartoes(produto, categoria, bandeira).stream()
                .map(CadastrarCartoesDtoModel::new)
                .collect(Collectors.toList()));
    }

    @PutMapping("/atualizar")
    @Transactional
    public  ResponseEntity<String> atualizarCartoes(@Param("id") String id,@RequestBody @Valid CadastrarCartoesDtoModel cadastrarCartoesDtoModel) {

        return ResponseEntity.ok(produtoInterface.atualizarCartoes(id, cadastrarCartoesDtoModel));
    }
    @DeleteMapping
    @Transactional
    public  ResponseEntity<String> deletaCartoes(@Param("id") String id) {
      return ResponseEntity.ok(produtoInterface.deletaCartao(id));
    }
}
