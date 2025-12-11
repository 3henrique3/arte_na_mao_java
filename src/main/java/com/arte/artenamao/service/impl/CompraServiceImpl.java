package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.AtualizarCompraDto;
import com.arte.artenamao.dtos.CompraRecordDto;
import com.arte.artenamao.mappers.CompraMapper;
import com.arte.artenamao.model.CompraModel;
import com.arte.artenamao.repository.CompraRepository;
import com.arte.artenamao.service.CompraService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompraServiceImpl implements CompraService {
    Logger logger = LogManager.getLogger(CompraServiceImpl.class);

    private final CompraRepository compraRepository;
    private final CompraMapper compraMapper;

    public CompraServiceImpl(CompraRepository compraRepository, CompraMapper compraMapper) {
        this.compraRepository = compraRepository;
        this.compraMapper = compraMapper;
    }

    @Override
    public List<CompraModel> findAll() { return compraRepository.findAll(); }

    @Override
    public Optional<CompraModel> findById(UUID compraId) { return compraRepository.findById(compraId); }

    @Transactional
    @Override
    public CompraModel save(CompraRecordDto compraRecordDto) {
        var compraModel = compraMapper.toEntity(compraRecordDto);

        compraModel.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Recife")));
        compraModel.setDataAtualizacao(LocalDateTime.now(ZoneId.of("America/Recife")));

        return compraRepository.save(compraModel);
    }

    @Transactional
    @Override
    public CompraModel patch(CompraModel compraModel, AtualizarCompraDto atualizarCompraDto) {
        compraModel.setCompraStatusEnum(atualizarCompraDto.compraStatusEnum());

        return compraRepository.save(compraModel);
    }

    @Transactional
    @Override
    public void delete(CompraModel compraModel) {
        compraRepository.delete(compraModel);
    }
}
