package com.arte.artenamao.model;

import com.arte.artenamao.enums.CompraStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "compra")
public class CompraModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false)
    CompraStatusEnum compraStatusEnum;

    @ManyToOne
    @JoinColumn(name = "obraId")
    private ObraModel obraModel;

    @ManyToOne
    @JoinColumn(name = "artistaId")
    private ArtistaModel artistaModel;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private UsuarioModel usuarioModel;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;
}
