package com.estrelinha.cartaocredito.controller;

import com.estrelinha.cartaocredito.model.dto.PegarCartoesDtoModel;
import com.estrelinha.cartaocredito.service.interfaces.SimulacaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/simulacao")
public class SimulacaoController {
    @Autowired
    private SimulacaoInterface simulacaoInterface;

    @GetMapping("/cartao")
    public ResponseEntity<List<PegarCartoesDtoModel>> getCartoes() {
        return ResponseEntity.ok(simulacaoInterface.getCartoes());
    }

    @GetMapping("/produto/{produto}")
    public ResponseEntity<List<PegarCartoesDtoModel>> getProduto(@PathVariable String produto) {
        return ResponseEntity.ok(simulacaoInterface.getProduto(produto));
    }

    @GetMapping("/bandeira/{bandeira}")
    public ResponseEntity<List<PegarCartoesDtoModel>> getBandeira(@PathVariable String bandeira) {
        return ResponseEntity.ok(simulacaoInterface.getBandeira(bandeira));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<PegarCartoesDtoModel>> getCategoria(@PathVariable String categoria) {
        return  ResponseEntity.ok(simulacaoInterface.getCategoria(categoria));
    }

    @GetMapping("/contratar")
    public ResponseEntity<PegarCartoesDtoModel> getCartao(@Param("produto") String produto,
                                          @Param("categoria") String categoria,
                                          @Param("bandeira") String bandeira) {
        return ResponseEntity.ok(simulacaoInterface.getCartao(produto, categoria, bandeira));
    }

}
