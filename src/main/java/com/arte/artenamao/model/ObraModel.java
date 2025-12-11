package com.arte.artenamao.model;

import com.arte.artenamao.enums.TipoObraEnum;
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
@Table(name = "obra")
public class ObraModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private TipoObraEnum tipoObraEnum;

    @Column(nullable = true)
    private double preco;

    @Column(nullable = true)
    private String caminhoFoto;

    @CreationTimestamp
    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "artistaId",
            referencedColumnName = "id",
            nullable = false)
    private ArtistaModel artistaModel;

    @OneToMany(mappedBy = "obraModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarrinhoModel> obrasCarrinhoModel;

    @OneToMany(mappedBy = "obraModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraModel> compraObraModel;
}