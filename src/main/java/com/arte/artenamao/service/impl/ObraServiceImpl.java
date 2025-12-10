package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.mappers.ObraMapper;
import com.arte.artenamao.model.ObraModel;
import com.arte.artenamao.repository.ObraRepository;
import com.arte.artenamao.service.ObraService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ObraServiceImpl implements ObraService {

    private final ObraRepository obraRepository;
    private final ObraMapper obraMapper;

    public ObraServiceImpl(ObraRepository obraRepository, ObraMapper obraMapper) {
        this.obraRepository = obraRepository;
        this.obraMapper = obraMapper;
    }

    @Override
    public ObraRecordDto save(ObraRecordDto dto){
        ObraModel obra = obraMapper.toEntity(dto);
        var newObra = obraRepository.save(obra);
        return obraMapper.toDto(newObra);
    }

    @Override
    public List<ObraModel> findAll() {
        return List.of();
    }

    @Override
    public Optional<ObraModel> findById(UUID obraId) {
        return Optional.empty();
    }

    @Override
    public ObraModel update(ObraModel ObraModel, ObraRecordDto obraRecordDto) {
        return null;
    }

    @Override
    public void delete(ObraModel ObraModel) {

    }
}
