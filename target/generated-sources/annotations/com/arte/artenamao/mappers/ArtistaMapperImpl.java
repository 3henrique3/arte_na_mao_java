package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.UsuarioModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T23:24:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ArtistaMapperImpl implements ArtistaMapper {

    @Override
    public ArtistaModel toEntity(UsuarioRecordDto dto, UsuarioModel usuario) {
        if ( dto == null && usuario == null ) {
            return null;
        }

        ArtistaModel artistaModel = new ArtistaModel();

        if ( dto != null ) {
            artistaModel.setNome( dto.nome() );
            artistaModel.setCpf( dto.cpf() );
            artistaModel.setCnpj( dto.cnpj() );
            artistaModel.setTelefone( dto.telefone() );
            artistaModel.setDataNascimento( dto.dataNascimento() );
        }
        if ( usuario != null ) {
            artistaModel.setUsuarioModel( usuario );
            artistaModel.setDataCriacao( usuario.getDataCriacao() );
            artistaModel.setDataAtualizacao( usuario.getDataAtualizacao() );
        }

        return artistaModel;
    }
}
