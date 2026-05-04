package com.reparaciones.api.dto;

import jakarta.validation.constraints.NotBlank;

public class MarcaRequest {
    @NotBlank(message = "El nombre de la marca es requerido")
    private String nombre;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}