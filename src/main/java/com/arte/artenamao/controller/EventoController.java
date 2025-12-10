package com.arte.artenamao.controller;

import com.arte.artenamao.dtos.EventoRecordDto;
import com.arte.artenamao.model.EventoModel;
import com.arte.artenamao.service.EventoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    Logger logger = LogManager.getLogger(EventoController.class);
    
    final EventoService eventoService;
    
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }
    
    @PostMapping("/criar")
    public ResponseEntity<Object> saveEvento(@RequestBody EventoRecordDto eventoRecordDto){

        logger.debug("POST: concluído", eventoRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.save(eventoRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<EventoModel>> getEventos(){
        List<EventoModel> eventoCadastro = eventoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(eventoCadastro);
    }

    @GetMapping("/achar-evento/{eventoId}")
    public ResponseEntity<Object> acharEvento(@PathVariable(value = "eventoId") UUID eventoId) {
        logger.debug("Get: concluído", eventoId);

        return ResponseEntity.status(HttpStatus.OK).body(eventoService.findById(eventoId));
    }

    @PutMapping("/atualizar-evento/{eventoId}")
    public ResponseEntity<Object> updateEvento(@PathVariable(value = "eventoId") UUID eventoId, @RequestBody EventoRecordDto eventoRecordDto) {
        logger.debug("PUT: update concluído", eventoId);

        return ResponseEntity.status(HttpStatus.OK).body(eventoService.update(eventoService.findById(eventoId).get(), eventoRecordDto));
    }

    @PatchMapping("/patch/{eventoId}")
    public ResponseEntity<Object> patchEvento(@PathVariable(value = "eventoId") UUID eventoId, @RequestBody EventoRecordDto eventoRecordDto){
        logger.debug("PATCH: Patch concluído", eventoId);
        return ResponseEntity.status(HttpStatus.OK).body(eventoService.patch(eventoService.findById(eventoId).get(), eventoRecordDto));
    }

    @DeleteMapping("/delete/{eventoId}")
    public ResponseEntity<Object> deleteEvento(@PathVariable(value = "eventoId") UUID eventoId) {
        eventoService.delete(eventoService.findById(eventoId).get());
        logger.debug("Delete: Delete concluído", eventoId);
        return ResponseEntity.noContent().build();
    }
}
