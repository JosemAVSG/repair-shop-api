package com.reparaciones.api.controller;

import com.reparaciones.domain.enums.EstadoOrden;
import com.reparaciones.domain.model.*;
import com.reparaciones.domain.repository.*;
import com.reparaciones.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenController {

    private final OrdenRepository ordenRepository;
    private final ReparacionRepository reparacionRepository;
    private final HistorialRepository historialRepository;

    public OrdenController(OrdenRepository ordenRepository, ReparacionRepository reparacionRepository,
                            HistorialRepository historialRepository) {
        this.ordenRepository = ordenRepository;
        this.reparacionRepository = reparacionRepository;
        this.historialRepository = historialRepository;
    }

    @GetMapping
    public ApiResponse<List<OrdenResponse>> getAll() {
        List<OrdenResponse> ordenes = ordenRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(ordenes);
    }

    @GetMapping("/{id}")
    public ApiResponse<OrdenResponse> getById(@PathVariable Long id) {
        return ordenRepository.findById(id)
                .map(o -> ApiResponse.success(toResponse(o)))
                .orElse(ApiResponse.error("Orden no encontrada"));
    }

    @GetMapping("/estado/{estado}")
    public ApiResponse<List<OrdenResponse>> getByEstado(@PathVariable EstadoOrden estado) {
        List<OrdenResponse> ordenes = ordenRepository.findByEstado(estado).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(ordenes);
    }

    @PostMapping
    public ApiResponse<OrdenResponse> create(@Valid @RequestBody OrdenRequest request) {
        OrdenTrabajo orden = new OrdenTrabajo();
        orden.setClienteId(request.getClienteId());
        orden.setDispositivoId(request.getDispositivoId());
        orden.setFalloReportado(request.getFalloReportado());
        orden.setNotas(request.getNotas());
        orden.setEstado(EstadoOrden.REGISTRO);
        orden.setFechaEntrada(LocalDateTime.now());
        orden.setCreatedBy("system");

        OrdenTrabajo saved = ordenRepository.save(orden);

        // Guardar en historial
        HistorialEntrada historial = new HistorialEntrada("ORDEN", saved.getId(),
                "Orden creada - Estado: REGISTRO");
        historial.setCreatedBy("system");
        historialRepository.save(historial);

        return ApiResponse.success(toResponse(saved));
    }

    @PutMapping("/{id}/estado")
    public ApiResponse<OrdenResponse> updateEstado(@PathVariable Long id, @RequestParam EstadoOrden estado) {
        return ordenRepository.findById(id)
                .map(o -> {
                    o.setEstado(estado);
                    if (estado == EstadoOrden.ENTREGADO) {
                        o.setFechaSalida(LocalDateTime.now());
                    }
                    OrdenTrabajo saved = ordenRepository.save(o);

                    // Guardar en historial
                    HistorialEntrada historial = new HistorialEntrada("ORDEN", saved.getId(),
                            "Estado cambiado a: " + estado);
                    historial.setCreatedBy("system");
                    historialRepository.save(historial);

                    return ApiResponse.success(toResponse(saved));
                })
                .orElse(ApiResponse.error("Orden no encontrada"));
    }

    @PutMapping("/{id}")
    public ApiResponse<OrdenResponse> update(@PathVariable Long id, @RequestBody OrdenRequest request) {
        return ordenRepository.findById(id)
                .map(o -> {
                    o.setFalloReportado(request.getFalloReportado());
                    o.setNotas(request.getNotas());
                    return ApiResponse.success(toResponse(ordenRepository.save(o)));
                })
                .orElse(ApiResponse.error("Orden no encontrada"));
    }

    // Reparaciones
    @PostMapping("/{ordenId}/reparaciones")
    public ApiResponse<ReparacionResponse> addReparacion(@PathVariable Long ordenId,
                                                          @Valid @RequestBody ReparacionRequest request) {
        return ordenRepository.findById(ordenId)
                .map(orden -> {
                    Reparacion reparacion = new Reparacion();
                    reparacion.setOrdenId(ordenId);
                    reparacion.setTipo(request.getTipo());
                    reparacion.setDescripcion(request.getDescripcion());
                    reparacion.setPrecio(request.getPrecio());
                    reparacion.setCreatedBy("system");

                    Reparacion saved = reparacionRepository.save(reparacion);

                    // Actualizar precio total
                    double nuevoTotal = orden.getPrecioTotal() != null ?
                            orden.getPrecioTotal() + request.getPrecio() : request.getPrecio();
                    orden.setPrecioTotal(nuevoTotal);
                    ordenRepository.save(orden);

                    return ApiResponse.success(toReparacionResponse(saved));
                })
                .orElse(ApiResponse.error("Orden no encontrada"));
    }

    @GetMapping("/{ordenId}/reparaciones")
    public ApiResponse<List<ReparacionResponse>> getReparaciones(@PathVariable Long ordenId) {
        List<ReparacionResponse> reparaciones = reparacionRepository.findByOrdenId(ordenId).stream()
                .map(this::toReparacionResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(reparaciones);
    }

    private OrdenResponse toResponse(OrdenTrabajo o) {
        OrdenResponse r = new OrdenResponse();
        r.setId(o.getId());
        r.setClienteId(o.getClienteId());
        r.setDispositivoId(o.getDispositivoId());
        r.setEstado(o.getEstado());
        r.setFalloReportado(o.getFalloReportado());
        r.setPrecioTotal(o.getPrecioTotal());
        r.setFechaEntrada(o.getFechaEntrada());
        r.setFechaSalida(o.getFechaSalida());
        r.setNotas(o.getNotas());
        r.setCreatedAt(o.getCreatedAt());

        List<ReparacionResponse> reps = reparacionRepository.findByOrdenId(o.getId()).stream()
                .map(this::toReparacionResponse)
                .collect(Collectors.toList());
        r.setReparaciones(reps);
        return r;
    }

    private ReparacionResponse toReparacionResponse(Reparacion r) {
        ReparacionResponse resp = new ReparacionResponse();
        resp.setId(r.getId());
        resp.setOrdenId(r.getOrdenId());
        resp.setTipo(r.getTipo());
        resp.setDescripcion(r.getDescripcion());
        resp.setPrecio(r.getPrecio());
        resp.setCreatedAt(r.getCreatedAt());
        return resp;
    }
}