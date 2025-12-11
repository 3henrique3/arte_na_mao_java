package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.EventoRecordDto;
import com.arte.artenamao.model.EventoModel;
import org.mapstruct.Mapper;

@Mapper
public interface EventoMapper {
    EventoModel toEntity(EventoRecordDto dto);
}
