package com.arte.artenamao.mappers;

import com.arte.artenamao.dtos.UsuarioRecordDto;
import com.arte.artenamao.dtos.UsuarioResponseDto;
import com.arte.artenamao.enums.TipoUsuarioEnum;
import com.arte.artenamao.model.ArtistaModel;
import com.arte.artenamao.model.ClienteModel;
import com.arte.artenamao.model.UsuarioModel;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T23:43:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioModel toEntity(UsuarioRecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setEmail( dto.email() );
        usuarioModel.setSenha( dto.senha() );
        usuarioModel.setTipoUsuarioEnum( dto.tipoUsuarioEnum() );

        return usuarioModel;
    }

    @Override
    public UsuarioResponseDto toDto(UsuarioModel usuario) {
        if ( usuario == null ) {
            return null;
        }

        String nome = null;
        String cpf = null;
        String cnpj = null;
        String telefone = null;
        LocalDate dataNascimento = null;
        UUID id = null;
        String email = null;
        TipoUsuarioEnum tipoUsuarioEnum = null;

        String nome1 = usuarioClienteModelNome( usuario );
        if ( nome1 != null ) {
            nome = nome1;
        }
        else {
            nome = usuario.getArtistaModel().getNome();
        }
        String cpf1 = usuarioClienteModelCpf( usuario );
        if ( cpf1 != null ) {
            cpf = cpf1;
        }
        else {
            cpf = usuario.getArtistaModel().getCpf();
        }
        cnpj = usuarioArtistaModelCnpj( usuario );
        String telefone1 = usuarioClienteModelTelefone( usuario );
        if ( telefone1 != null ) {
            telefone = telefone1;
        }
        else {
            telefone = usuario.getArtistaModel().getTelefone();
        }
        LocalDate dataNascimento1 = usuarioClienteModelDataNascimento( usuario );
        if ( dataNascimento1 != null ) {
            dataNascimento = dataNascimento1;
        }
        else {
            dataNascimento = usuario.getArtistaModel().getDataNascimento();
        }
        id = usuario.getId();
        email = usuario.getEmail();
        tipoUsuarioEnum = usuario.getTipoUsuarioEnum();

        String logradouro = getEndereco(usuario).getLogradouro();
        String bairro = getEndereco(usuario).getBairro();
        Double numero = getEndereco(usuario).getNumero();
        String cidade = getEndereco(usuario).getCidade();
        String estado = getEndereco(usuario).getEstado();
        String pais = getEndereco(usuario).getPais();

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto( id, email, tipoUsuarioEnum, nome, cpf, cnpj, telefone, dataNascimento, logradouro, bairro, numero, cidade, estado, pais );

        return usuarioResponseDto;
    }

    private String usuarioClienteModelNome(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }
        ClienteModel clienteModel = usuarioModel.getClienteModel();
        if ( clienteModel == null ) {
            return null;
        }
        String nome = clienteModel.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String usuarioClienteModelCpf(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }
        ClienteModel clienteModel = usuarioModel.getClienteModel();
        if ( clienteModel == null ) {
            return null;
        }
        String cpf = clienteModel.getCpf();
        if ( cpf == null ) {
            return null;
        }
        return cpf;
    }

    private String usuarioArtistaModelCnpj(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }
        ArtistaModel artistaModel = usuarioModel.getArtistaModel();
        if ( artistaModel == null ) {
            return null;
        }
        String cnpj = artistaModel.getCnpj();
        if ( cnpj == null ) {
            return null;
        }
        return cnpj;
    }

    private String usuarioClienteModelTelefone(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }
        ClienteModel clienteModel = usuarioModel.getClienteModel();
        if ( clienteModel == null ) {
            return null;
        }
        String telefone = clienteModel.getTelefone();
        if ( telefone == null ) {
            return null;
        }
        return telefone;
    }

    private LocalDate usuarioClienteModelDataNascimento(UsuarioModel usuarioModel) {
        if ( usuarioModel == null ) {
            return null;
        }
        ClienteModel clienteModel = usuarioModel.getClienteModel();
        if ( clienteModel == null ) {
            return null;
        }
        LocalDate dataNascimento = clienteModel.getDataNascimento();
        if ( dataNascimento == null ) {
            return null;
        }
        return dataNascimento;
    }
}
