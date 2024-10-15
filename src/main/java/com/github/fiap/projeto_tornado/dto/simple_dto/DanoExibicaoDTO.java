package com.github.fiap.projeto_tornado.dto.simple_dto;

import com.github.fiap.projeto_tornado.model.Danos;

public record DanoExibicaoDTO(
        Long id,
        Long idTornado,
        String dano,
        String local

) {
    public DanoExibicaoDTO (Danos danos){
        this(danos.getId(), danos.getIdTornado(), danos.getDano(), danos.getLocal());
    }
}
