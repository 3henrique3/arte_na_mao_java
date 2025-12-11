package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.ObraRecordDto;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.ObraModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ObraMapper {

    @Mapping(target = "artistaModel", source = "artistaId", qualifiedByName = "mapArtista")
    @Mapping(target = "obrasCarrinhoModel", ignore = true)
    ObraModel toEntity(ObraRecordDto dto);

    @Mapping(target = "artistaId", source = "artistaModel.id")
    @Mapping(target = "preco", source = "preco")
    ObraRecordDto toDto(ObraModel model);

    @Named("mapArtista")
    default ArtistaModel mapArtistaIdToArtista(UUID artistaId) {
        if (artistaId == null) return null;
        ArtistaModel artista = new ArtistaModel();
        artista.setId(artistaId);
        return artista;
    }
}
