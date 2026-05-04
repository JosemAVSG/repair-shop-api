package com.reparaciones.api.dto;

import jakarta.validation.constraints.NotNull;

public class OrdenRequest {
    @NotNull(message = "El cliente es requerido")
    private Long clienteId;
    @NotNull(message = "El dispositivo es requerido")
    private Long dispositivoId;
    private String falloReportado;
    private String notas;

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getDispositivoId() { return dispositivoId; }
    public void setDispositivoId(Long dispositivoId) { this.dispositivoId = dispositivoId; }
    public String getFalloReportado() { return falloReportado; }
    public void setFalloReportado(String falloReportado) { this.falloReportado = falloReportado; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}