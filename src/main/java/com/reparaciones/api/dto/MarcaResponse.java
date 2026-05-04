package com.reparaciones.api.dto;

import java.time.LocalDateTime;
import com.reparaciones.domain.model.CategoriaMarca;

public class MarcaResponse {
    private Long id;
    private String nombre;
    private CategoriaMarca categoria;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public CategoriaMarca getCategoria() { return categoria; }
    public void setCategoria(CategoriaMarca categoria) { this.categoria = categoria; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}