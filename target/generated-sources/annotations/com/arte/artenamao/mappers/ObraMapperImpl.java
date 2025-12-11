package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.enums.TipoObraEnum;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.ObraModel;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-10T20:30:12-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class ObraMapperImpl implements ObraMapper {

    @Override
    public ObraModel toEntity(ObraRecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        ObraModel obraModel = new ObraModel();

        obraModel.setArtistaModel( mapArtistaIdToArtista( dto.artistaId() ) );
        obraModel.setDescricao( dto.descricao() );
        obraModel.setTipoObraEnum( dto.tipoObraEnum() );
        obraModel.setPreco( dto.preco() );
        obraModel.setCaminhoFoto( dto.caminhoFoto() );

        return obraModel;
    }

    @Override
    public ObraRecordDto toDto(ObraModel model) {
        if ( model == null ) {
            return null;
        }

        UUID artistaId = null;
        double preco = 0.0d;
        String descricao = null;
        TipoObraEnum tipoObraEnum = null;
        String caminhoFoto = null;

        artistaId = modelArtistaModelId( model );
        preco = model.getPreco();
        descricao = model.getDescricao();
        tipoObraEnum = model.getTipoObraEnum();
        caminhoFoto = model.getCaminhoFoto();

        String nome = null;

        ObraRecordDto obraRecordDto = new ObraRecordDto( nome, descricao, tipoObraEnum, preco, caminhoFoto, artistaId );

        return obraRecordDto;
    }

    private UUID modelArtistaModelId(ObraModel obraModel) {
        if ( obraModel == null ) {
            return null;
        }
        ArtistaModel artistaModel = obraModel.getArtistaModel();
        if ( artistaModel == null ) {
            return null;
        }
        UUID id = artistaModel.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
