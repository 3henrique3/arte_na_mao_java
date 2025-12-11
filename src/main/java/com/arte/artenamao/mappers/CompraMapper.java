package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.CompraRecordDto;
import com.arte.artenamao.model.CompraModel;

public interface CompraMapper {
    CompraModel toEntity(CompraRecordDto dto);
}
