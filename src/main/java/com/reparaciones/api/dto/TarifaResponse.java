package com.reparaciones.api.dto;

import com.reparaciones.domain.enums.TipoReparacion;
import java.time.LocalDateTime;

public class TarifaResponse {
    private Long id;
    private Long marcaId;
    private Long modeloId;
    private TipoReparacion tipo;
    private Double precio;
    private boolean activa;
    private LocalDateTime createdAt;

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
}