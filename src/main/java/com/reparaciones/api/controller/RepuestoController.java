package com.reparaciones.api.controller;

import com.reparaciones.api.dto.ApiResponse;
import com.reparaciones.api.dto.RepuestoRequest;
import com.reparaciones.api.dto.RepuestoResponse;
import com.reparaciones.domain.model.Repuesto;
import com.reparaciones.domain.repository.RepuestoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/repuestos")
public class RepuestoController {

    private final RepuestoRepository repuestoRepository;

    public RepuestoController(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @GetMapping
    public ApiResponse<List<RepuestoResponse>> getAll() {
        List<RepuestoResponse> repuestos = repuestoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(repuestos);
    }

    @GetMapping("/bajo-stock")
    public ApiResponse<List<RepuestoResponse>> getBajoStock() {
        List<RepuestoResponse> repuestos = repuestoRepository.findBajoStock().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(repuestos);
    }

    @GetMapping("/{id}")
    public ApiResponse<RepuestoResponse> getById(@PathVariable Long id) {
        return repuestoRepository.findById(id)
                .map(r -> ApiResponse.success(toResponse(r)))
                .orElse(ApiResponse.error("Repuesto no encontrado"));
    }

    @PostMapping
    public ApiResponse<RepuestoResponse> create(@Valid @RequestBody RepuestoRequest request) {
        Repuesto repuesto = new Repuesto();
        repuesto.setNombre(request.getNombre());
        repuesto.setDescripcion(request.getDescripcion());
        repuesto.setCodigo(request.getCodigo());
        repuesto.setPrecioCosto(request.getPrecioCosto());
        repuesto.setPrecioVenta(request.getPrecioVenta());
        repuesto.setStockActual(request.getStockActual());
        repuesto.setStockMinimo(request.getStockMinimo());
        repuesto.setProveedorId(request.getProveedorId());
        repuesto.setCreatedBy("system");

        Repuesto saved = repuestoRepository.save(repuesto);
        return ApiResponse.success(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ApiResponse<RepuestoResponse> update(@PathVariable Long id, @Valid @RequestBody RepuestoRequest request) {
        return repuestoRepository.findById(id)
                .map(r -> {
                    r.setNombre(request.getNombre());
                    r.setDescripcion(request.getDescripcion());
                    r.setCodigo(request.getCodigo());
                    r.setPrecioCosto(request.getPrecioCosto());
                    r.setPrecioVenta(request.getPrecioVenta());
                    r.setStockActual(request.getStockActual());
                    r.setStockMinimo(request.getStockMinimo());
                    r.setProveedorId(request.getProveedorId());
                    return ApiResponse.success(toResponse(repuestoRepository.save(r)));
                })
                .orElse(ApiResponse.error("Repuesto no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        if (repuestoRepository.findById(id).isPresent()) {
            repuestoRepository.deleteById(id);
            return ApiResponse.success(null);
        }
        return ApiResponse.error("Repuesto no encontrado");
    }

    private RepuestoResponse toResponse(Repuesto r) {
        RepuestoResponse resp = new RepuestoResponse();
        resp.setId(r.getId());
        resp.setNombre(r.getNombre());
        resp.setDescripcion(r.getDescripcion());
        resp.setCodigo(r.getCodigo());
        resp.setPrecioCosto(r.getPrecioCosto());
        resp.setPrecioVenta(r.getPrecioVenta());
        resp.setStockActual(r.getStockActual());
        resp.setStockMinimo(r.getStockMinimo());
        resp.setProveedorId(r.getProveedorId());
        resp.setBajoStock(r.necesitaReposicion());
        resp.setCreatedAt(r.getCreatedAt());
        return resp;
    }
}