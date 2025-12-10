package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.TipoObraEnum;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record ObraRecordDto(

        @NotBlank(message = "A descrição é obrigatória.")
        String nome,

        @NotBlank(message = "A descrição é obrigatória.")
        @Size(min = 3, max = 255, message = "A descrição deve ter entre 3 e 255 caracteres.")
        String descricao,

        @NotNull(message = "O tipo da obra é obrigatório.")
        TipoObraEnum tipoObraEnum,

        @PositiveOrZero(message = "O preço não pode ser negativo.")
        double preco,

        @Size(max = 500, message = "O caminho da foto deve ter no máximo 500 caracteres.")
        String caminhoFoto,

        @NotNull(message = "O ID do artista é obrigatório.")
        UUID artistaId

) {}
