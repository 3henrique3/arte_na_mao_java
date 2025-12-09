package com.arte.artenamao.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "carrinho")
public class CarrinhoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuarioId",
            referencedColumnName = "id",
            nullable = false)
    private UsuarioModel usuarioModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "obraId",
            referencedColumnName = "id",
            nullable = false)
    private ObraModel obraModel;
}