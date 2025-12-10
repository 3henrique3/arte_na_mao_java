package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.dtos.UsuarioResponseDto;
import com.arte.artenamao.model.EnderecoModel;
import com.arte.artenamao.model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioModel toEntity(UsuarioRecordDto dto);


    @Mapping(target = "nome", source = "clienteModel.nome", defaultExpression = "java(usuario.getArtistaModel().getNome())")
    @Mapping(target = "cpf", source = "clienteModel.cpf", defaultExpression = "java(usuario.getArtistaModel().getCpf())")
    @Mapping(target = "cnpj", source = "artistaModel.cnpj")
    @Mapping(target = "telefone", source = "clienteModel.telefone", defaultExpression = "java(usuario.getArtistaModel().getTelefone())")
    @Mapping(target = "dataNascimento", source = "clienteModel.dataNascimento",
            defaultExpression = "java(usuario.getArtistaModel().getDataNascimento())")

    @Mapping(target = "logradouro", expression = "java(getEndereco(usuario).getLogradouro())")
    @Mapping(target = "bairro", expression = "java(getEndereco(usuario).getBairro())")
    @Mapping(target = "numero", expression = "java(getEndereco(usuario).getNumero())")
    @Mapping(target = "cidade", expression = "java(getEndereco(usuario).getCidade())")
    @Mapping(target = "estado", expression = "java(getEndereco(usuario).getEstado())")
    @Mapping(target = "pais", expression = "java(getEndereco(usuario).getPais())")

    UsuarioResponseDto toDto(UsuarioModel usuario);

    default EnderecoModel getEndereco(UsuarioModel usuario) {
        if (usuario.getClienteModel() != null) {
            return usuario.getClienteModel().getEnderecoModel();
        }
        if (usuario.getArtistaModel() != null) {
            return usuario.getArtistaModel().getEnderecoModel();
        }
        return null;
    }
}
