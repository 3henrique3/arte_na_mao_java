package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.CompraStatusEnum;

import java.util.UUID;

public record CompraRecordDto (
        CompraStatusEnum compraStatusEnum,
        UUID obraId,
        UUID artistaId,
        UUID usuarioId
){}
