package com.reparaciones.domain.model;

import java.time.LocalDateTime;

public class Dispositivo {
    private Long id;
    private Long modeloId;
    private Long clienteId;
    private String numeroSerie;
    private String imei;
    private String notasTecnicas;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;

    public Dispositivo() {}

    public Dispositivo(Long id, Long modeloId, Long clienteId) {
        this.id = id;
        this.modeloId = modeloId;
        this.clienteId = clienteId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getModeloId() { return modeloId; }
    public void setModeloId(Long modeloId) { this.modeloId = modeloId; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public String getNumeroSerie() { return numeroSerie; }
    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }
    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }
    public String getNotasTecnicas() { return notasTecnicas; }
    public void setNotasTecnicas(String notasTecnicas) { this.notasTecnicas = notasTecnicas; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}