package com.paulohenriquepaulo.api_consultar_cep.exeception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Data
public class CepNaoEncontradoExeception extends RuntimeException {

    private final Map<String, String> erros;

    private HttpStatus status;

    public CepNaoEncontradoExeception() {
        this.erros = new HashMap<>();
    }

    public CepNaoEncontradoExeception(String descrcao, HttpStatus status) {
        this();
        this.status = status;
        add("status", String.valueOf(status.value()));
        add("mensagem", descrcao);
    }

    public void add(String erro, String descricao) {
        this.erros.put(erro, descricao);
    }

}
