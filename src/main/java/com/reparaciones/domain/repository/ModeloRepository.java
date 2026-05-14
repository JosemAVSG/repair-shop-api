package com.reparaciones.domain.repository;

import java.util.List;
import java.util.Optional;

import com.reparaciones.domain.model.Modelo;

public interface ModeloRepository {
    List<Modelo> findAll();
    Optional<Modelo> findById(Long id);
    Modelo save(Modelo modelo);
    void deleteById(Long id);
    List<Modelo> findByMarcaId(Long marcaId);
}