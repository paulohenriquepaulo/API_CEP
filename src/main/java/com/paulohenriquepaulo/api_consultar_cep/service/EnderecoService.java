package com.paulohenriquepaulo.api_consultar_cep.service;

import com.google.gson.Gson;
import com.paulohenriquepaulo.api_consultar_cep.exeception.CepNaoEncontradoExeception;
import com.paulohenriquepaulo.api_consultar_cep.model.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class EnderecoService {
    static String webService = "https://viacep.com.br/ws/";
    static int codigoSucesso = 200;

    public Endereco buscarEnderecoPeloCep(String cep) throws IOException {
        String urlChamada = webService + cep + "/json";


        URL url = new URL(urlChamada);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        if (connection.getResponseCode() != codigoSucesso) {
            throw new CepNaoEncontradoExeception("CEP invalido" , HttpStatus.NOT_FOUND);
        }

        BufferedReader resposta = new BufferedReader
                (new InputStreamReader((connection.getInputStream())));

        String jsonEmString = Util.converterJsonEmString(resposta);

        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
        return endereco;
    }
}
