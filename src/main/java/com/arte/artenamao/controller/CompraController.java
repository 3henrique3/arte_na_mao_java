package com.arte.artenamao.controller;

import com.arte.artenamao.dtos.AtualizarCompraDto;
import com.arte.artenamao.dtos.CompraRecordDto;
import com.arte.artenamao.model.CompraModel;
import com.arte.artenamao.service.CompraService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/compra")
public class CompraController {
    Logger logger = LogManager.getLogger(CompraController.class);

    final private CompraService compraService;

    public CompraController(CompraService compraService){
        this.compraService = compraService;
    }

    @PostMapping("/comprarObra")
    public ResponseEntity<Object> saveCompra(@RequestBody CompraRecordDto compraRecordDto){

        logger.debug("POST: compra em andamento", compraRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraService.save(compraRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<CompraModel>> getCompras(){
        List<CompraModel> compraRegistros = compraService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(compraRegistros);
    }

    @PatchMapping("/status/{compraId}")
    public ResponseEntity<Object> patchStatus(@PathVariable(value = "compraId") UUID compraId, @RequestBody AtualizarCompraDto atualizarCompraDto) {
        logger.debug("PATCH: Status da compra atualizado", compraId);
        return ResponseEntity.status(HttpStatus.OK).body(compraService.patch(compraService.findById(compraId).get(), atualizarCompraDto));
    }

    @DeleteMapping("/{compraId}")
    public ResponseEntity<Object> deleteCompra(@PathVariable(value = "compraId") UUID compraId) {
        compraService.delete(compraService.findById(compraId).get());
        logger.debug("DELETE: concluído", compraId);
        return ResponseEntity.noContent().build();
    }
}
