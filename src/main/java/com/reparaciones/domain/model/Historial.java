package com.reparaciones.domain.model;

import java.time.LocalDateTime;

public class Historial {
    private Long id;
    private Long clienteId;
    private Long dispositivoId;
    private Long ordenId;
    private String descripcion;
    private LocalDateTime fecha;
    private String createdBy;

    public Historial() {}

    public Historial(Long clienteId, Long dispositivoId, Long ordenId,
                     String descripcion, String createdBy) {
        this.clienteId = clienteId;
        this.dispositivoId = dispositivoId;
        this.ordenId = ordenId;
        this.descripcion = descripcion;
        this.fecha = LocalDateTime.now();
        this.createdBy = createdBy;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getDispositivoId() { return dispositivoId; }
    public void setDispositivoId(Long dispositivoId) { this.dispositivoId = dispositivoId; }
    public Long getOrdenId() { return ordenId; }
    public void setOrdenId(Long ordenId) { this.ordenId = ordenId; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}