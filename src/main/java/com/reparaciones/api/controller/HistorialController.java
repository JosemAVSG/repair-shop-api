package com.reparaciones.api.controller;

import com.reparaciones.domain.model.HistorialEntrada;
import com.reparaciones.domain.repository.HistorialRepository;
import com.reparaciones.api.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/historial")
public class HistorialController {

    private final HistorialRepository historialRepository;

    public HistorialController(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    @GetMapping("/{entidadTipo}/{entidadId}")
    public ApiResponse<List<HistorialResponse>> getByEntidad(@PathVariable String entidadTipo,
                                                              @PathVariable Long entidadId) {
        List<HistorialResponse> historial = historialRepository
                .findByEntidadTipoAndEntidadId(entidadTipo, entidadId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(historial);
    }

    private HistorialResponse toResponse(HistorialEntrada h) {
        HistorialResponse r = new HistorialResponse();
        r.setId(h.getId());
        r.setEntidadTipo(h.getEntidadTipo());
        r.setEntidadId(h.getEntidadId());
        r.setContenido(h.getContenido());
        r.setCreatedAt(h.getCreatedAt());
        return r;
    }

    public static class HistorialResponse {
        private Long id;
        private String entidadTipo;
        private Long entidadId;
        private String contenido;
        private java.time.LocalDateTime createdAt;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getEntidadTipo() { return entidadTipo; }
        public void setEntidadTipo(String entidadTipo) { this.entidadTipo = entidadTipo; }
        public Long getEntidadId() { return entidadId; }
        public void setEntidadId(Long entidadId) { this.entidadId = entidadId; }
        public String getContenido() { return contenido; }
        public void setContenido(String contenido) { this.contenido = contenido; }
        public java.time.LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
}