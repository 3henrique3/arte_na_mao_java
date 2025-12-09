package com.arte.artenamao.model;

import com.arte.artenamao.enums.TipoUsuarioEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private TipoUsuarioEnum tipoUsuarioEnum;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @OneToOne(mappedBy = "usuarioModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private ClienteModel clienteModel;

    @OneToOne(mappedBy = "usuarioModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArtistaModel artistaModel;

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarrinhoModel> usuariosCarrinhoModel;

    @OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<EventoModel> usuarioEventoModel;
}