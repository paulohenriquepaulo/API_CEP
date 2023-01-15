package com.paulohenriquepaulo.api_consultar_cep.controller;

import com.paulohenriquepaulo.api_consultar_cep.model.Endereco;
import com.paulohenriquepaulo.api_consultar_cep.service.EnderecoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buscar")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    @SneakyThrows
    public ResponseEntity<Endereco> getEnderecoPorCep(@RequestParam String cep) {
        Endereco endereco = service.buscarEnderecoPeloCep(cep);
        return  ResponseEntity.ok(endereco);
    }
}
