package com.arte.artenamao.service;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.dtos.UsuarioResponseDto;
import com.arte.artenamao.model.UsuarioModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    // CREATE
    UsuarioResponseDto createUsuario(UsuarioRecordDto dto);

    // READ
    UsuarioResponseDto findById(UUID id);
    Optional<UsuarioResponseDto> findByEmail(String email);
    List<UsuarioResponseDto> findAll();

    // UPDATE
    UsuarioResponseDto updateUsuario(UUID id, UsuarioRecordDto dto);

    // DELETE
    void deleteUsuario(UUID id);

    // Métodos auxiliares
    boolean existsById(UUID id);
    boolean existsByEmail(String email);
}
