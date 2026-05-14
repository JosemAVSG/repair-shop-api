package com.reparaciones.domain.repository;

import java.util.List;

import com.reparaciones.domain.model.HistorialEntrada;

public interface HistorialRepository {
    List<HistorialEntrada> findAll();
    HistorialEntrada save(HistorialEntrada entrada);
    List<HistorialEntrada> findByEntidadTipoAndEntidadId(String entidadTipo, Long entidadId);
    void deleteById(Long id);
}