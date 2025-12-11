package com.arte.artenamao.controller;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.service.impl.ObraServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/obras")
@CrossOrigin(origins = "*")
public class ObraController {
    private final ObraServiceImpl obraService;

    public ObraController(ObraServiceImpl obraService) {
        this.obraService = obraService;
    }

    @PostMapping
    public ResponseEntity<?> createObra(@RequestBody ObraRecordDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(obraService.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(obraService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateObra(
            @PathVariable UUID id,
            @RequestBody @Valid ObraRecordDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(obraService.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObra(@PathVariable UUID id) {
        try {
            obraService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
