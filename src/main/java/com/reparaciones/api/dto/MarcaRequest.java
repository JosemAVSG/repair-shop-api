package com.reparaciones.api.dto;

import com.reparaciones.domain.model.CategoriaMarca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MarcaRequest {
    @NotBlank(message = "El nombre de la marca es requerido")
    private String nombre;

    @NotNull(message = "La categoría es requerida")
    private CategoriaMarca categoria;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public CategoriaMarca getCategoria() { return categoria; }
    public void setCategoria(CategoriaMarca categoria) { this.categoria = categoria; }
}