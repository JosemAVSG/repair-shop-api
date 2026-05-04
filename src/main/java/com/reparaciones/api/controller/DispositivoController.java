package com.reparaciones.api.controller;

import com.reparaciones.domain.model.Dispositivo;
import com.reparaciones.domain.model.TipoDispositivo;
import com.reparaciones.domain.repository.DispositivoRepository;
import com.reparaciones.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dispositivos")
public class DispositivoController {

    private final DispositivoRepository dispositivoRepository;

    public DispositivoController(DispositivoRepository dispositivoRepository) {
        this.dispositivoRepository = dispositivoRepository;
    }

    @GetMapping
    public ApiResponse<List<DispositivoResponse>> getAll() {
        List<DispositivoResponse> dispositivos = dispositivoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(dispositivos);
    }

    @GetMapping("/{id}")
    public ApiResponse<DispositivoResponse> getById(@PathVariable Long id) {
        return dispositivoRepository.findById(id)
                .map(d -> ApiResponse.success(toResponse(d)))
                .orElse(ApiResponse.error("Dispositivo no encontrado"));
    }

    @GetMapping("/cliente/{clienteId}")
    public ApiResponse<List<DispositivoResponse>> getByCliente(@PathVariable Long clienteId) {
        List<DispositivoResponse> dispositivos = dispositivoRepository.findByClienteId(clienteId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(dispositivos);
    }

    @PostMapping
    public ApiResponse<DispositivoResponse> create(@Valid @RequestBody DispositivoRequest request) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setTipo(request.getTipo());
        dispositivo.setModeloId(request.getModeloId());
        dispositivo.setClienteId(request.getClienteId());
        dispositivo.setNumeroSerie(request.getNumeroSerie());
        dispositivo.setImei(request.getImei());
        dispositivo.setNotasTecnicas(request.getNotasTecnicas());
        dispositivo.setCreatedBy("system");

        Dispositivo saved = dispositivoRepository.save(dispositivo);
        return ApiResponse.success(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ApiResponse<DispositivoResponse> update(@PathVariable Long id, @RequestBody DispositivoRequest request) {
        return dispositivoRepository.findById(id)
                .map(d -> {
                    d.setTipo(request.getTipo());
                    d.setNumeroSerie(request.getNumeroSerie());
                    d.setImei(request.getImei());
                    d.setNotasTecnicas(request.getNotasTecnicas());
                    return ApiResponse.success(toResponse(dispositivoRepository.save(d)));
                })
                .orElse(ApiResponse.error("Dispositivo no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        if (dispositivoRepository.findById(id).isPresent()) {
            dispositivoRepository.deleteById(id);
            return ApiResponse.success(null);
        }
        return ApiResponse.error("Dispositivo no encontrado");
    }

    private DispositivoResponse toResponse(Dispositivo d) {
        DispositivoResponse r = new DispositivoResponse();
        r.setId(d.getId());
        r.setTipo(d.getTipo());
        r.setModeloId(d.getModeloId());
        r.setClienteId(d.getClienteId());
        r.setNumeroSerie(d.getNumeroSerie());
        r.setImei(d.getImei());
        r.setNotasTecnicas(d.getNotasTecnicas());
        r.setCreatedAt(d.getCreatedAt());
        return r;
    }

    public static class DispositivoRequest {
        private TipoDispositivo tipo;
        private Long modeloId;
        private Long clienteId;
        private String numeroSerie;
        private String imei;
        private String notasTecnicas;

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
    }

    public static class DispositivoResponse {
        private Long id;
        private TipoDispositivo tipo;
        private Long modeloId;
        private Long clienteId;
        private String numeroSerie;
        private String imei;
        private String notasTecnicas;
        private java.time.LocalDateTime createdAt;

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
        public java.time.LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}