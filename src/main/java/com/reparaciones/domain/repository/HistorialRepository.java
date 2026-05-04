package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.HistorialEntrada;
import java.util.List;

public interface HistorialRepository {
    List<HistorialEntrada> findAll();
    HistorialEntrada save(HistorialEntrada entrada);
    List<HistorialEntrada> findByEntidadTipoAndEntidadId(String entidadTipo, Long entidadId);
    void deleteById(Long id);
}