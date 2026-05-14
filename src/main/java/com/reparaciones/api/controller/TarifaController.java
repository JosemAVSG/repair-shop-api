package com.reparaciones.api.controller;

import com.reparaciones.domain.enums.TipoReparacion;
import com.reparaciones.domain.model.Tarifa;
import com.reparaciones.domain.repository.TarifaRepository;
import com.reparaciones.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    private final TarifaRepository tarifaRepository;

    public TarifaController(TarifaRepository tarifaRepository) {
        this.tarifaRepository = tarifaRepository;
    }

    @GetMapping
    public ApiResponse<List<TarifaResponse>> getAll() {
        List<TarifaResponse> tarifas = tarifaRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(tarifas);
    }

    @GetMapping("/activas")
    public ApiResponse<List<TarifaResponse>> getActivas() {
        List<TarifaResponse> tarifas = tarifaRepository.findByActivaTrue().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(tarifas);
    }

    @GetMapping("/modelo/{modeloId}")
    public ApiResponse<List<TarifaResponse>> getByModelo(@PathVariable Long modeloId) {
        List<TarifaResponse> tarifas = tarifaRepository.findByModeloId(modeloId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(tarifas);
    }

    @GetMapping("/marca/{marcaId}")
    public ApiResponse<List<TarifaResponse>> getByMarca(@PathVariable Long marcaId) {
        List<TarifaResponse> tarifas = tarifaRepository.findByMarcaId(marcaId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(tarifas);
    }

    @GetMapping("/modelo/{modeloId}/tipo/{tipo}")
    public ApiResponse<TarifaResponse> getByModeloAndTipo(@PathVariable Long modeloId,
            @PathVariable TipoReparacion tipo) {
        return tarifaRepository.findByModeloIdAndTipo(modeloId, tipo)
                .map(t -> ApiResponse.success(toResponse(t)))
                .orElse(ApiResponse.error("Tarifa no encontrada"));
    }

    @PostMapping
    public ApiResponse<TarifaResponse> create(@Valid @RequestBody TarifaRequest request) {
        Tarifa tarifa = new Tarifa();
        tarifa.setMarcaId(request.getMarcaId());
        tarifa.setModeloId(request.getModeloId());
        tarifa.setTipo(request.getTipo());
        tarifa.setPrecio(request.getPrecio());
        tarifa.setActiva(true);
        tarifa.setCreatedBy("system");

        Tarifa saved = tarifaRepository.save(tarifa);
        return ApiResponse.success(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ApiResponse<TarifaResponse> update(@PathVariable Long id, @Valid @RequestBody TarifaRequest request) {
        return tarifaRepository.findById(id)
                .map(t -> {
                    t.setPrecio(request.getPrecio());
                    t.setActiva(true);
                    return ApiResponse.success(toResponse(tarifaRepository.save(t)));
                })
                .orElse(ApiResponse.error("Tarifa no encontrada"));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        if (tarifaRepository.findById(id).isPresent()) {
            tarifaRepository.deleteById(id);
            return ApiResponse.success(null);
        }
        return ApiResponse.error("Tarifa no encontrada");
    }

    private TarifaResponse toResponse(Tarifa t) {
        TarifaResponse r = new TarifaResponse();
        r.setId(t.getId());
        r.setMarcaId(t.getMarcaId());
        r.setModeloId(t.getModeloId());
        r.setTipo(t.getTipo());
        r.setPrecio(t.getPrecio());
        r.setActiva(t.isActiva());
        r.setCreatedAt(t.getCreatedAt());
        return r;
    }
}