package com.arte.artenamao.service;

import com.arte.artenamao.dtos.EventoRecordDto;
import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.model.EventoModel;
import com.arte.artenamao.model.ObraModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ObraService {
    public ObraRecordDto save(ObraRecordDto dto);

    List<ObraModel> findAll();

    Optional<ObraModel> findById(UUID obraId);

    ObraModel update(ObraModel ObraModel, ObraRecordDto obraRecordDto);

    void delete(ObraModel ObraModel);
}
