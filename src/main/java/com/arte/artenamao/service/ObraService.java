package com.arte.artenamao.service;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.model.ObraModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ObraService {
    public ObraRecordDto save(ObraRecordDto dto);

    List<ObraRecordDto> findAll();

    Optional<ObraRecordDto> findById(UUID obraId);

    ObraRecordDto update(UUID id, ObraRecordDto obraRecordDto);

    void delete(UUID id);
}
