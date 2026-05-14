package com.reparaciones.domain.model;

import java.time.LocalDateTime;

import com.reparaciones.domain.enums.TipoReparacion;

public class Tarifa {
    private Long id;
    private Long marcaId;
    private Long modeloId;
    private TipoReparacion tipo;
    private Double precio;
    private boolean activa;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    public Tarifa() {}

    public Tarifa(Long id, Long marcaId, Long modeloId, TipoReparacion tipo, Double precio) {
        this.id = id;
        this.marcaId = marcaId;
        this.modeloId = modeloId;
        this.tipo = tipo;
        this.precio = precio;
        this.activa = true;
    }

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