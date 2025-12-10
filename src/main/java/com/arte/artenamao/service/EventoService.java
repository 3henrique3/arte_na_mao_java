package com.arte.artenamao.service;

import com.arte.artenamao.dtos.EventoRecordDto;
import com.arte.artenamao.model.EventoModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventoService {
    List<EventoModel> findAll();

    Optional<EventoModel> findById(UUID eventoId);

    EventoModel save(EventoRecordDto eventoRecordDto);

    EventoModel update(EventoModel eventoModel, EventoRecordDto eventoRecordDto);

    void delete(EventoModel eventoModel);

    EventoModel patch(EventoModel eventoModel, EventoRecordDto eventoRecordDto);
}
