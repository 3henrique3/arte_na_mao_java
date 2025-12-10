package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.dtos.UsuarioResponseDto;
import com.arte.artenamao.mappers.ArtistaMapper;
import com.arte.artenamao.mappers.ClienteMapper;
import com.arte.artenamao.mappers.EnderecoMapper;
import com.arte.artenamao.mappers.UsuarioMapper;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.ClienteModel;
import com.arte.artenamao.model.EnderecoModel;
import com.arte.artenamao.model.UsuarioModel;
import com.arte.artenamao.repository.UsuarioRepository;
import com.arte.artenamao.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final ClienteMapper clienteMapper;
    private final ArtistaMapper artistaMapper;
    private final EnderecoMapper enderecoMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository1, UsuarioMapper usuarioMapper, ClienteMapper clienteMapper, ArtistaMapper artistaMapper, EnderecoMapper enderecoMapper){
        this.usuarioRepository = usuarioRepository1;
        this.usuarioMapper = usuarioMapper;
        this.clienteMapper = clienteMapper;
        this.artistaMapper = artistaMapper;
        this.enderecoMapper = enderecoMapper;
    }

    @Transactional
    @Override
    public UsuarioResponseDto createUsuario(UsuarioRecordDto dto) {
        UsuarioModel usuario = usuarioMapper.toEntity(dto);
        EnderecoModel endereco = enderecoMapper.toEntity(dto.endereco());

        if(dto.isCliente()){
            ClienteModel cliente = clienteMapper.toEntity(dto, usuario);
            cliente.setEnderecoModel(endereco);
            usuario.setClienteModel(cliente);
        } else if (dto.isArtista()) {
            ArtistaModel artista = artistaMapper.toEntity(dto, usuario);
            artista.setEnderecoModel(endereco);
            usuario.setArtistaModel(artista);
        }

        return usuarioMapper.toDto(usuario);
    }

    @Override
    public Optional<UsuarioModel> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UsuarioModel findById(UUID id) {
        return null;
    }
}
