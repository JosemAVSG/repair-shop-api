package com.reparaciones.api.dto;

import com.reparaciones.domain.model.EstadoOrden;
import java.time.LocalDateTime;
import java.util.List;

public class OrdenResponse {
    private Long id;
    private Long clienteId;
    private Long dispositivoId;
    private EstadoOrden estado;
    private String falloReportado;
    private Double precioTotal;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private String notas;
    private List<ReparacionResponse> reparaciones;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getDispositivoId() { return dispositivoId; }
    public void setDispositivoId(Long dispositivoId) { this.dispositivoId = dispositivoId; }
    public EstadoOrden getEstado() { return estado; }
    public void setEstado(EstadoOrden estado) { this.estado = estado; }
    public String getFalloReportado() { return falloReportado; }
    public void setFalloReportado(String falloReportado) { this.falloReportado = falloReportado; }
    public Double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(Double precioTotal) { this.precioTotal = precioTotal; }
    public LocalDateTime getFechaEntrada() { return fechaEntrada; }
    public void setFechaEntrada(LocalDateTime fechaEntrada) { this.fechaEntrada = fechaEntrada; }
    public LocalDateTime getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDateTime fechaSalida) { this.fechaSalida = fechaSalida; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
    public List<ReparacionResponse> getReparaciones() { return reparaciones; }
    public void setReparaciones(List<ReparacionResponse> reparaciones) { this.reparaciones = reparaciones; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}