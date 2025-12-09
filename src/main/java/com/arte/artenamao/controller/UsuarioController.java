package com.arte.artenamao.controller;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.service.impl.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UsuarioRecordDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                usuarioService.createUsuario(dto)
        );
    }

}
