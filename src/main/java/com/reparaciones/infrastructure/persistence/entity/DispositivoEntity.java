package com.reparaciones.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.reparaciones.domain.model.TipoDispositivo;

@Entity
@Table(name = "dispositivos")
public class DispositivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoDispositivo tipo;

    @Column(name = "modelo_id", nullable = false)
    private Long modeloId;

    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "numero_serie")
    private String numeroSerie;

    private String imei;

    @Column(name = "notas_tecnicas", columnDefinition = "TEXT")
    private String notasTecnicas;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public TipoDispositivo getTipo() { return tipo; }
    public void setTipo(TipoDispositivo tipo) { this.tipo = tipo; }
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