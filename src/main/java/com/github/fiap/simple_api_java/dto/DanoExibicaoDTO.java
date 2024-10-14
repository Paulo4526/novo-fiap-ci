package com.github.fiap.simple_api_java.dto;

import com.github.fiap.simple_api_java.model.Danos;

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
