package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.GeneroUsuarioEnum;
import com.arte.artenamao.enums.TipoUsuarioEnum;

import java.time.LocalDate;

public record UsuarioRecordDto(
        String email,
        String senha,

        TipoUsuarioEnum tipoUsuarioEnum,

        // campos comuns
        String nome,
        String cpf,
        GeneroUsuarioEnum genero,
        String telefone,
        LocalDate dataNascimento,

        // campos apenas para artista
        String cnpj,

        EnderecoRecordDto endereco
) {
}
