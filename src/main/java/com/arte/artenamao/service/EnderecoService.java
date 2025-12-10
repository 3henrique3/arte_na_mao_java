package com.arte.artenamao.service;

import com.arte.artenamao.dtos.EnderecoRecordDto;
import com.arte.artenamao.model.EnderecoModel;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    public EnderecoModel convertToEntity(EnderecoRecordDto enderecoRecordDto) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setLogradouro(enderecoRecordDto.logradouro());
        enderecoModel.setBairro(enderecoRecordDto.bairro());
        enderecoModel.setNumero(enderecoRecordDto.numero());
        enderecoModel.setCidade(enderecoRecordDto.cidade());
        enderecoModel.setEstado(enderecoRecordDto.estado());
        enderecoModel.setPais(enderecoRecordDto.pais());
        return enderecoModel;
    }
}