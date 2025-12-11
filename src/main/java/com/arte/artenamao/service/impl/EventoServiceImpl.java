package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.EventoRecordDto;
import com.arte.artenamao.mappers.EnderecoMapper;
import com.arte.artenamao.model.EnderecoModel;
import com.arte.artenamao.model.EventoModel;
import com.arte.artenamao.repository.EventoRepository;
import com.arte.artenamao.service.EventoService;
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
public class EventoServiceImpl implements EventoService {
    Logger logger = LogManager.getLogger(EventoServiceImpl.class);

    final EventoRepository eventoRepository;
    final EnderecoMapper enderecoMapper;

    public EventoServiceImpl(EventoRepository eventoRepository, EnderecoMapper enderecoMapper) {
        this.eventoRepository = eventoRepository;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public List<EventoModel> findAll() {
        return eventoRepository.findAll();
    }

    @Override
    public Optional<EventoModel> findById(UUID id) {
        return eventoRepository.findById(id);
    }

    @Transactional
    @Override
    public EventoModel save(EventoRecordDto eventoRecordDto) {
        var eventoModel = new EventoModel();
        BeanUtils.copyProperties(eventoRecordDto, eventoModel);

        eventoModel.setDataCriacao(LocalDateTime.now(ZoneId.of("America/Recife")));
        eventoModel.setDataAtualizacao(LocalDateTime.now(ZoneId.of("America/Recife")));

        return eventoRepository.save(eventoModel);
    }

    @Transactional
    @Override
    public EventoModel update(EventoModel eventoModel, EventoRecordDto eventoRecordDto) {
        eventoModel.setDescricao(eventoRecordDto.descricao());
        eventoModel.setTipoEventoEnum(eventoRecordDto.tipoEventoEnum());
        eventoModel.setTipoAdesaoEnum(eventoRecordDto.tipoAdesaoEnum());

        if (eventoRecordDto.endereco() != null) {
            // Converte o EnderecoRecordDto em EnderecoModel (se necessário)
            // Aqui você precisa de um serviço ou método para converter o DTO para a entidade correspondente
            EnderecoModel enderecoModel = enderecoMapper.toEntity(eventoRecordDto.endereco());
            eventoModel.setEnderecoModel(enderecoModel);
        }
        return eventoRepository.save(eventoModel);
    }

    @Transactional
    @Override
    public void delete(EventoModel eventoModel) {
        eventoRepository.delete(eventoModel);
    }

    @Override
    public EventoModel patch(EventoModel eventoModel, EventoRecordDto eventoRecordDto) {
        eventoModel.setDescricao(eventoRecordDto.descricao());
        eventoModel.setTipoEventoEnum(eventoRecordDto.tipoEventoEnum());
        eventoModel.setTipoAdesaoEnum(eventoRecordDto.tipoAdesaoEnum());

        return eventoRepository.save(eventoModel);
    }
}
