package com.github.fiap.projeto_tornado.dto.simple_dto;

import com.github.fiap.projeto_tornado.model.Clima;

import java.time.LocalDate;

public record ClimaExibicaoDTO(
        Long id,
        Long idTornado,
        String clima,
        Integer temperatura,
        LocalDate data,
        String local
) {
    public ClimaExibicaoDTO (Clima clima){
        this(clima.getId(), clima.getIdTornados(), clima.getClima(), clima.getTemperatura(), clima.getData(), clima.getLocal());
    }
}
