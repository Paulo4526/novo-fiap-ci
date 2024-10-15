package com.github.fiap.projeto_tornado.dto.simple_dto;
import com.github.fiap.projeto_tornado.model.Tornado;

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
