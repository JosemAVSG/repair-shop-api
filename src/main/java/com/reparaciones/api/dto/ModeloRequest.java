package com.reparaciones.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ModeloRequest {
    @NotBlank(message = "El nombre del modelo es requerido")
    private String nombre;
    @NotNull(message = "La marca es requerida")
    private Long marcaId;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
}