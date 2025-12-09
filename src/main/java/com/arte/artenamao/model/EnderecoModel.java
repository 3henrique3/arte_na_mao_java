package com.arte.artenamao.model;

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
@Table(name = "endereco")
public class EnderecoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = true)
    String logradouro;

    @Column(nullable = true)
    String bairro;

    @Column(nullable = true)
    double numero;

    @Column(nullable = true)
    String cidade;

    @Column(nullable = true)
    String estado;

    @Column(nullable = true)
    String pais;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @OneToOne(mappedBy = "enderecoModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArtistaModel artistaModel;

    @OneToOne(mappedBy = "enderecoModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private ClienteModel clienteModel;

    @OneToOne(mappedBy = "enderecoModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private EventoModel eventoModel;
}