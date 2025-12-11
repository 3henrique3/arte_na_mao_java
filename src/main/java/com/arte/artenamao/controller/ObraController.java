package com.arte.artenamao.controller;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.service.impl.ObraServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
