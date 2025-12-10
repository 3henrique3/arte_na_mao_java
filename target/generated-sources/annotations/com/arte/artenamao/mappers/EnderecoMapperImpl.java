package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.EnderecoRecordDto;
import com.arte.artenamao.model.EnderecoModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T23:24:28-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoModel toEntity(EnderecoRecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        EnderecoModel enderecoModel = new EnderecoModel();

        enderecoModel.setLogradouro( dto.logradouro() );
        enderecoModel.setBairro( dto.bairro() );
        if ( dto.numero() != null ) {
            enderecoModel.setNumero( dto.numero() );
        }
        enderecoModel.setCidade( dto.cidade() );
        enderecoModel.setEstado( dto.estado() );
        enderecoModel.setPais( dto.pais() );

        return enderecoModel;
    }
}
