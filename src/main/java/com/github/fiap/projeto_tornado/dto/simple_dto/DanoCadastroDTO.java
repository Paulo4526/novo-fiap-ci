package com.github.fiap.projeto_tornado.dto.simple_dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DanoCadastroDTO(
        Long id,
        @NotNull(message = "Um id de tornado valido é obrigatório!")
        Long idTornado,
        @NotBlank(message = "O preenchimento do campo dano é obrigatório!")
        String dano,

        @NotBlank(message = "O preenchimento do campo dano é obrigatório!")
        String local
) {
}
