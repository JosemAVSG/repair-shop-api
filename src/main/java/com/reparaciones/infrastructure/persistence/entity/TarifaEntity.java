package com.reparaciones.infrastructure.persistence.entity;

import com.reparaciones.domain.enums.TipoReparacion;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarifas")
public class TarifaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_id")
    private Long marcaId;

    @Column(name = "modelo_id")
    private Long modeloId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoReparacion tipo;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private boolean activa = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }
    public TipoReparacion getTipo() { return tipo; }
    public void setTipo(TipoReparacion tipo) { this.tipo = tipo; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}