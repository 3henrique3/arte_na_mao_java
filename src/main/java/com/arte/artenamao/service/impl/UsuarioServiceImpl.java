package com.arte.artenamao.service.impl;

import com.arte.artenamao.dtos.EnderecoRecordDto;
import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.enums.TipoUsuarioEnum;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.ClienteModel;
import com.arte.artenamao.model.EnderecoModel;
import com.arte.artenamao.model.UsuarioModel;
import com.arte.artenamao.repository.ArtistaRepository;
import com.arte.artenamao.repository.ClienteRepository;
import com.arte.artenamao.repository.EnderecoRepository;
import com.arte.artenamao.repository.UsuarioRepository;
import com.arte.artenamao.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final ArtistaRepository artistaRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository, ArtistaRepository artistaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.artistaRepository = artistaRepository;
    }

    @Transactional
    @Override
    public UsuarioModel createUsuario(UsuarioRecordDto dto) {
        UsuarioModel usuario = criarUsuarioBase(dto);
        usuario = usuarioRepository.save(usuario);

        if(usuario.getTipoUsuarioEnum() == TipoUsuarioEnum.CLIENTE) {
            criarCliente(usuario, dto);
        } else if (usuario.getTipoUsuarioEnum() == TipoUsuarioEnum.ARTISTA){
            criarArtista(usuario, dto);
        }

        return usuario;
    }

    @Override
    public Optional<UsuarioModel> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public UsuarioModel findById(UUID id) {
        return null;
    }

    @Transactional
    private UsuarioModel criarUsuarioBase(UsuarioRecordDto dto) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha());
        usuario.setTipoUsuarioEnum(dto.tipoUsuarioEnum());
        return usuario;
    }

    @Transactional
    private void criarCliente(UsuarioModel usuario, UsuarioRecordDto dto) {
        ClienteModel cliente = new ClienteModel();
        cliente.setUsuarioModel(usuario);
        cliente.setNome(dto.nome());
        cliente.setCpf(dto.cpf());
        cliente.setGeneroUsuarioEnum(dto.genero());
        cliente.setTelefone(dto.telefone());
        cliente.setDataNascimento(dto.dataNascimento());
        cliente.setEnderecoModel(mapearEndereco(dto.endereco()));

        clienteRepository.save(cliente);
    }

    @Transactional
    private void criarArtista(UsuarioModel usuario, UsuarioRecordDto dto) {
        ArtistaModel artista = new ArtistaModel();
        artista.setUsuarioModel(usuario);
        artista.setNome(dto.nome());
        artista.setCpf(dto.cpf());
        artista.setCnpj(dto.cnpj());
        artista.setGeneroUsuarioEnum(dto.genero());
        artista.setTelefone(dto.telefone());
        artista.setDataNascimento(dto.dataNascimento());
        artista.setEnderecoModel(mapearEndereco(dto.endereco()));

        artistaRepository.save(artista);
    }

    private EnderecoModel mapearEndereco(EnderecoRecordDto dto) {
        EnderecoModel endereco = new EnderecoModel();
        endereco.setLogradouro(dto.logradouro());
        endereco.setBairro(dto.bairro());
        endereco.setNumero(dto.numero());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setPais(dto.pais());
        return endereco;
    }


}
