package com.arte.artenamao.model;

import com.arte.artenamao.enums.GeneroUsuarioEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private GeneroUsuarioEnum generoUsuarioEnum;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = true)
    private LocalDate dataNascimento;

    @Column(nullable = true)
    private String urlFotoAvatar;

    @Column(nullable = true)
    private String urlFotoBanner;

    @CreationTimestamp
    @Column(
            name = "data_criacao",
            nullable = false,
            updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(
            name = "data_atualizacao",
            nullable = false)
    private LocalDateTime dataAtualizacao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuarioId",
            referencedColumnName = "id",
            nullable = false,
            unique = true)
    private UsuarioModel usuarioModel;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "enderecoId",
            referencedColumnName = "id",
            nullable = true,
            unique = true)
    private EnderecoModel enderecoModel;
}