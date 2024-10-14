package com.github.fiap.simple_api_java.dto;
import com.github.fiap.simple_api_java.model.Tornado;

import java.time.LocalDate;

public record TornadoExibicaoDTO(
        Long id,
        String nome,
        String classificacao,
        String local,
        LocalDate data
) {
    public TornadoExibicaoDTO (Tornado tornado){
        this(tornado.getId(), tornado.getNome(), tornado.getClassificacao(), tornado.getLocal(), tornado.getData());
    }
}
