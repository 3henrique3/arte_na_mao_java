package com.arte.artenamao.service;

import com.arte.artenamao.dtos.AtualizarCompraDto;
import com.arte.artenamao.dtos.CompraRecordDto;
import com.arte.artenamao.model.CompraModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompraService {
    List<CompraModel> findAll();

    Optional<CompraModel> findById(UUID compraId);

    CompraModel save(CompraRecordDto compraRecordDto);

    CompraModel patch(CompraModel compraModel, AtualizarCompraDto atualizarCompraDto);

    void delete(CompraModel compraModel);
}
