package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.TipoUsuarioEnum;

import java.time.LocalDate;
import java.util.UUID;

public record UsuarioResponseDto(
        UUID id,
        String email,
        TipoUsuarioEnum tipoUsuarioEnum,

        // dados pessoais
        String nome,
        String cpf,
        String cnpj,
        String telefone,
        LocalDate dataNascimento,

        // endereço
        String logradouro,
        String bairro,
        Double numero,
        String cidade,
        String estado,
        String pais
) {}
