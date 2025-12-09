package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.GeneroUsuarioEnum;
import com.arte.artenamao.enums.TipoUsuarioEnum;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UsuarioRecordDto(
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        String senha,

        @NotNull(message = "Tipo de usuário é obrigatório")
        TipoUsuarioEnum tipoUsuarioEnum,

        // Campos comuns (
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        GeneroUsuarioEnum genero,

        String telefone,

        @Past(message = "Data de nascimento deve ser no passado")
        LocalDate dataNascimento,

        // Campo apenas para artista (opcional)
        String cnpj,

        // Endereço (obrigatório)
        @NotNull(message = "Endereço é obrigatório")
        EnderecoRecordDto endereco
) {
    // Método helper para validar se é artista
    public boolean isArtista() {
        return tipoUsuarioEnum == TipoUsuarioEnum.ARTISTA;
    }

    // Método helper para validar se é cliente
    public boolean isCliente() {
        return tipoUsuarioEnum == TipoUsuarioEnum.CLIENTE;
    }
}