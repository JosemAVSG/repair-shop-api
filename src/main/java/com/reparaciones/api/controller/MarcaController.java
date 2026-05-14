package com.reparaciones.api.controller;

import com.reparaciones.domain.enums.CategoriaMarca;
import com.reparaciones.domain.model.Marca;
import com.reparaciones.domain.repository.MarcaRepository;
import com.reparaciones.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    private final MarcaRepository marcaRepository;

    public MarcaController(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @GetMapping
    public ApiResponse<List<MarcaResponse>> getAll() {
        List<MarcaResponse> marcas = marcaRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(marcas);
    }

    @GetMapping("/{id}")
    public ApiResponse<MarcaResponse> getById(@PathVariable Long id) {
        return marcaRepository.findById(id)
                .map(m -> ApiResponse.success(toResponse(m)))
                .orElse(ApiResponse.error("Marca no encontrada"));
    }

    @PostMapping
    public ApiResponse<MarcaResponse> create(@Valid @RequestBody MarcaRequest request) {
        Marca marca = new Marca();
        marca.setNombre(request.getNombre());
        marca.setCategoria(request.getCategoria());
        marca.setCreatedBy("system");

        Marca saved = marcaRepository.save(marca);
        return ApiResponse.success(toResponse(saved));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        if (marcaRepository.findById(id).isPresent()) {
            marcaRepository.deleteById(id);
            return ApiResponse.success(null);
        }
        return ApiResponse.error("Marca no encontrada");
    }

    private MarcaResponse toResponse(Marca m) {
        MarcaResponse r = new MarcaResponse();
        r.setId(m.getId());
        r.setNombre(m.getNombre());
        r.setCategoria(m.getCategoria());
        r.setCreatedAt(m.getCreatedAt());
        return r;
    }
}