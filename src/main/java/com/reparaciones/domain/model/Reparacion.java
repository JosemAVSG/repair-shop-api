package com.reparaciones.domain.model;

import java.time.LocalDateTime;

import com.reparaciones.domain.enums.TipoReparacion;

public class Reparacion {
    private Long id;
    private Long ordenId;
    private TipoReparacion tipo;
    private String descripcion;
    private Double precio;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    public Reparacion() {}

    public Reparacion(Long id, Long ordenId, TipoReparacion tipo, String descripcion, Double precio) {
        this.id = id;
        this.ordenId = ordenId;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrdenId() { return ordenId; }
    public void setOrdenId(Long ordenId) { this.ordenId = ordenId; }
    public TipoReparacion getTipo() { return tipo; }
    public void setTipo(TipoReparacion tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}