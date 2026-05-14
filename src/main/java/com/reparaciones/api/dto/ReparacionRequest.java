package com.reparaciones.api.dto;

import com.reparaciones.domain.enums.TipoReparacion;
import jakarta.validation.constraints.NotNull;

public class ReparacionRequest {
    @NotNull(message = "El tipo de reparación es requerido")
    private TipoReparacion tipo;
    private String descripcion;
    private Double precio;

    public TipoReparacion getTipo() { return tipo; }
    public void setTipo(TipoReparacion tipo) { this.tipo = tipo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
}