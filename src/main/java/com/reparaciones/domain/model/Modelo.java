package com.reparaciones.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private Long id;
    private String nombre;
    private Long marcaId;
    private List<Componente> componentes = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    public Modelo() {}

    public Modelo(Long id, String nombre, Long marcaId) {
        this.id = id;
        this.nombre = nombre;
        this.marcaId = marcaId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Long getMarcaId() { return marcaId; }
    public void setMarcaId(Long marcaId) { this.marcaId = marcaId; }
    public List<Componente> getComponentes() { return componentes; }
    public void setComponentes(List<Componente> componentes) { this.componentes = componentes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}