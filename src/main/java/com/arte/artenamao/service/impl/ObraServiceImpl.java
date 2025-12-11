package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.mappers.ObraMapper;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.ObraModel;
import com.arte.artenamao.repository.ArtistaRepository;
import com.arte.artenamao.repository.ObraRepository;
import com.arte.artenamao.service.ObraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ObraServiceImpl implements ObraService {

    private final ObraRepository obraRepository;
    private final ArtistaRepository artistaRepository;
    private final ObraMapper obraMapper;

    public ObraServiceImpl(ObraRepository obraRepository, ArtistaRepository artistaRepository, ObraMapper obraMapper) {
        this.obraRepository = obraRepository;
        this.artistaRepository = artistaRepository;
        this.obraMapper = obraMapper;
    }

    @Override
    public ObraRecordDto save(ObraRecordDto dto){
        ObraModel obra = obraMapper.toEntity(dto);
        var newObra = obraRepository.save(obra);
        return obraMapper.toDto(newObra);
    }

    @Override
    public List<ObraRecordDto> findAll() {
        return obraRepository.findAll().stream()
                .map(obraMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ObraRecordDto> findById(UUID obraId) {
        ObraModel obra = obraRepository.findById(obraId)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada com ID: " + obraId));
        return Optional.ofNullable(obraMapper.toDto(obra));
    }

    @Transactional
    @Override
    public ObraRecordDto update(UUID id, ObraRecordDto dto) {
        ObraModel obra = obraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obra não encontrada com ID: " + id));


        obra.setTitulo(dto.titulo());
        obra.setDescricao(dto.descricao());
        obra.setTipoObraEnum(dto.tipoObraEnum());
        obra.setPreco(dto.preco());
        obra.setCaminhoFoto(dto.caminhoFoto());

        if (!obra.getArtistaModel().getId().equals(dto.artistaId())) {
            ArtistaModel artista = artistaRepository.findById(dto.artistaId())
                    .orElseThrow(() -> new RuntimeException("Artista não encontrado com ID: " + dto.artistaId()));
            obra.setArtistaModel(artista);
        }

        ObraModel updatedObra = obraRepository.save(obra);
        return  obraMapper.toDto(updatedObra);
    }

    @Override
    public void delete(UUID id) {
        if (!obraRepository.existsById(id)) {
            throw new RuntimeException("Obra não encontrada com ID: " + id);
        }
        obraRepository.deleteById(id);
    }
}
