package com.paulohenriquepaulo.api_consultar_cep.controller.advice;

import com.paulohenriquepaulo.api_consultar_cep.exeception.CepNaoEncontradoExeception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CepNaoEncontradoExeception.class)
    public ResponseEntity<Map<String, String>> cepNaoEncontradoExeception(CepNaoEncontradoExeception exeception) {
        return ResponseEntity.status(exeception.getStatus()).body(exeception.getErros());
    }
}
