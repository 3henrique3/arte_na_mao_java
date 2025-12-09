package com.arte.artenamao.model;

import com.arte.artenamao.enums.TipoAdesaoEnum;
import com.arte.artenamao.enums.TipoEventoEnum;
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
@Table(name = "evento")
public class EventoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private TipoEventoEnum tipoEventoEnum;

    @Column(nullable = false)
    private TipoAdesaoEnum tipoAdesaoEnum;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @OneToOne
    @JoinColumn(
            name = "artistaId",
            referencedColumnName = "id",
            nullable = false,
            unique = true)
    private ArtistaModel artistaModel;

    @OneToOne
    @JoinColumn(
            name = "enderecoId",
            referencedColumnName = "id",
            nullable = false,
            unique = true)
    private EnderecoModel enderecoModel;

    @OneToOne
    @JoinColumn(
            name = "eventoDiaHorarioId",
            referencedColumnName = "id",
            nullable = false,
            unique = true)
    private EventoDiaHorarioModel eventoDiaHorarioModel;

    @ManyToOne
    @JoinColumn(
            name = "usuarioId",
            referencedColumnName = "id",
            nullable = false)
    private UsuarioModel usuarioModel;
}