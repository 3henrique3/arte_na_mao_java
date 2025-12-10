package com.arte.artenamao.service;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.dtos.UsuarioResponseDto;
import com.arte.artenamao.model.UsuarioModel;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {
    UsuarioResponseDto createUsuario(UsuarioRecordDto dto);
    Optional<UsuarioModel> findByEmail(String email);
    UsuarioModel findById(UUID id);
}
