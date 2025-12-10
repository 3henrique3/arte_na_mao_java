package com.arte.artenamao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "evento_dia_horario")
public class EventoDiaHorarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Integer diaInicio;

    @Column(nullable = false)
    private Integer diaFim;

    @Column(nullable = false)
    private Integer horaInicio;

    @Column(nullable = false)
    private Integer minutoInicio;

    @Column(nullable = false)
    private Integer horaFim;

    @Column(nullable = false)
    private Integer minutoFim;

    @OneToOne(mappedBy = "eventoDiaHorarioModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private EventoModel eventoModel;
}
