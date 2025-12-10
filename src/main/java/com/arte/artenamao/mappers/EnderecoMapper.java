package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.EnderecoRecordDto;
import com.arte.artenamao.model.EnderecoModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    EnderecoModel toEntity(EnderecoRecordDto dto);
}
