package com.arte.artenamao.controller;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.dtos.UsuarioResponseDto;
import com.arte.artenamao.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> createUsuario(@RequestBody @Valid UsuarioRecordDto dto) {
        if (usuarioService.existsByEmail(dto.email())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        UsuarioResponseDto response = usuarioService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> findAll() {
        List<UsuarioResponseDto> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> findById(@PathVariable UUID id) {
        try {
            UsuarioResponseDto response = usuarioService.findById(id);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> updateUsuario(
            @PathVariable UUID id,
            @RequestBody @Valid UsuarioRecordDto dto) {
        try {
            UsuarioResponseDto response = usuarioService.update(id, dto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable UUID id) {
        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}