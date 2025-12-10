package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.model.ClienteModel;
import com.arte.artenamao.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioModel", source = "usuario")
    @Mapping(target = "enderecoModel", ignore = true)
    ClienteModel toEntity(UsuarioRecordDto dto, UsuarioModel usuario);
}
