package com.paulohenriquepaulo.api_consultar_cep.model;

import lombok.Data;

@Data
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String ddd;

}
