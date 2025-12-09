package com.arte.artenamao.dtos;

public record EnderecoRecordDto(
        String logradouro,
        String bairro,
        double numero,
        String cidade,
        String estado,
        String pais
){}
