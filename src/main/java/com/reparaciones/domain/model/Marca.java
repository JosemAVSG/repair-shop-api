package com.reparaciones.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.reparaciones.domain.enums.CategoriaMarca;

public class Marca {
    private Long id;
    private String nombre;
    private CategoriaMarca categoria;
    private List<Modelo> modelos = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    public Marca() {}

    public Marca(Long id, String nombre, CategoriaMarca categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public CategoriaMarca getCategoria() { return categoria; }
    public void setCategoria(CategoriaMarca categoria) { this.categoria = categoria; }
    public List<Modelo> getModelos() { return modelos; }
    public void setModelos(List<Modelo> modelos) { this.modelos = modelos; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}