package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.TipoAdesaoEnum;
import com.arte.artenamao.enums.TipoEventoEnum;

import java.util.UUID;

public record EventoRecordDto (
    String descricao,
    TipoEventoEnum tipoEventoEnum,
    TipoAdesaoEnum tipoAdesaoEnum,
    UUID artistaId,
    EnderecoRecordDto endereco,
    EventoDiaHorarioRecordDto eventoDiaHorario,
    UUID usuarioId
){}
