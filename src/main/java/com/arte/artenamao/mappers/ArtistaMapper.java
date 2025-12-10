package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioModel", source = "usuario")
    @Mapping(target = "enderecoModel", ignore = true)
    ArtistaModel toEntity(UsuarioRecordDto dto, UsuarioModel usuario);
}