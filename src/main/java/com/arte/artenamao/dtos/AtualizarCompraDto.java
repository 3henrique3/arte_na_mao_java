package com.arte.artenamao.dtos;

import com.arte.artenamao.enums.CompraStatusEnum;

public record AtualizarCompraDto (
  CompraStatusEnum compraStatusEnum
){}
