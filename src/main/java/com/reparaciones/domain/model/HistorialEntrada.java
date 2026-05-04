package com.reparaciones.domain.model;

import java.time.LocalDateTime;

public class HistorialEntrada {
    private Long id;
    private String entidadTipo; // CLIENTE, DISPOSITIVO, ORDEN
    private Long entidadId;
    private String contenido;
    private LocalDateTime createdAt;
    private String createdBy;

    public HistorialEntrada() {}

    public HistorialEntrada(String entidadTipo, Long entidadId, String contenido) {
        this.entidadTipo = entidadTipo;
        this.entidadId = entidadId;
        this.contenido = contenido;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEntidadTipo() { return entidadTipo; }
    public void setEntidadTipo(String entidadTipo) { this.entidadTipo = entidadTipo; }
    public Long getEntidadId() { return entidadId; }
    public void setEntidadId(Long entidadId) { this.entidadId = entidadId; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}