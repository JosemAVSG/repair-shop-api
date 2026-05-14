package com.reparaciones.api.dto;

import com.reparaciones.domain.enums.TipoReparacion;
import jakarta.validation.constraints.NotNull;

public class TarifaRequest {
    private Long marcaId;
    private Long modeloId;
    @NotNull(message = "El tipo de reparación es requerido")
    private TipoReparacion tipo;
    @NotNull(message = "El precio es requerido")
    private Double precio;

    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }
    public TipoReparacion getTipo() { return tipo; }
    public void setTipo(TipoReparacion tipo) { this.tipo = tipo; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
}