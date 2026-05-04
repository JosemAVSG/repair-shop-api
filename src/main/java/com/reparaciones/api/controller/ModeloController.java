package com.reparaciones.api.controller;

import com.reparaciones.domain.model.Modelo;
import com.reparaciones.domain.repository.ModeloRepository;
import com.reparaciones.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloRepository modeloRepository;

    public ModeloController(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    @GetMapping
    public ApiResponse<List<ModeloResponse>> getAll() {
        List<ModeloResponse> modelos = modeloRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(modelos);
    }

    @GetMapping("/{id}")
    public ApiResponse<ModeloResponse> getById(@PathVariable Long id) {
        return modeloRepository.findById(id)
                .map(m -> ApiResponse.success(toResponse(m)))
                .orElse(ApiResponse.error("Modelo no encontrado"));
    }

    @GetMapping("/marca/{marcaId}")
    public ApiResponse<List<ModeloResponse>> getByMarca(@PathVariable Long marcaId) {
        List<ModeloResponse> modelos = modeloRepository.findByMarcaId(marcaId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(modelos);
    }

    @PostMapping
    public ApiResponse<ModeloResponse> create(@Valid @RequestBody ModeloRequest request) {
        Modelo modelo = new Modelo();
        modelo.setNombre(request.getNombre());
        modelo.setMarcaId(request.getMarcaId());
        modelo.setCreatedBy("system");

        Modelo saved = modeloRepository.save(modelo);
        return ApiResponse.success(toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        if (modeloRepository.findById(id).isPresent()) {
            modeloRepository.deleteById(id);
            return ApiResponse.success(null);
        }
        return ApiResponse.error("Modelo no encontrado");
    }

    private ModeloResponse toResponse(Modelo m) {
        ModeloResponse r = new ModeloResponse();
        r.setId(m.getId());
        r.setNombre(m.getNombre());
        r.setMarcaId(m.getMarcaId());
        r.setCreatedAt(m.getCreatedAt());
        return r;
    }
}