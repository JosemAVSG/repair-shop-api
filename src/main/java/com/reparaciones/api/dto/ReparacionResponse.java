package com.reparaciones.api.dto;

import com.reparaciones.domain.enums.TipoReparacion;
import java.time.LocalDateTime;

public class ReparacionResponse {
    private Long id;
    private Long ordenId;
    private TipoReparacion tipo;
    private String descripcion;
    private Double precio;
    private LocalDateTime createdAt;

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
}