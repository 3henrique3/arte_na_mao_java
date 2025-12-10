package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.model.ClienteModel;
import com.arte.artenamao.model.UsuarioModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T23:24:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteModel toEntity(UsuarioRecordDto dto, UsuarioModel usuario) {
        if ( dto == null && usuario == null ) {
            return null;
        }

        ClienteModel clienteModel = new ClienteModel();

        if ( dto != null ) {
            clienteModel.setNome( dto.nome() );
            clienteModel.setCpf( dto.cpf() );
            clienteModel.setTelefone( dto.telefone() );
            clienteModel.setDataNascimento( dto.dataNascimento() );
        }
        if ( usuario != null ) {
            clienteModel.setUsuarioModel( usuario );
            clienteModel.setDataCriacao( usuario.getDataCriacao() );
            clienteModel.setDataAtualizacao( usuario.getDataAtualizacao() );
        }

        return clienteModel;
    }
}
