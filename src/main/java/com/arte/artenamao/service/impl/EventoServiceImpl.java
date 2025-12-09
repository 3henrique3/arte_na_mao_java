package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.EventoRecordDto;
import com.arte.artenamao.model.EnderecoModel;
import com.arte.artenamao.model.EventoModel;
import com.arte.artenamao.repository.EventoRepository;
import com.arte.artenamao.service.EnderecoService;
import com.arte.artenamao.service.EventoService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {
    Logger logger = LogManager.getLogger(EventoServiceImpl.class);

    final EventoRepository eventoRepository;
    final EnderecoService enderecoService;

    public EventoServiceImpl(EventoRepository eventoRepository, EnderecoService enderecoService) {
        this.eventoRepository = eventoRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public List<EventoModel> findAll() {
        return eventoRepository.findAll();
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
            EnderecoModel enderecoModel = enderecoService.convertToEntity(eventoRecordDto.endereco());
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
