package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.Modelo;
import java.util.List;
import java.util.Optional;

public interface ModeloRepository {
    List<Modelo> findAll();
    Optional<Modelo> findById(Long id);
    Modelo save(Modelo modelo);
    void deleteById(Long id);
    List<Modelo> findByMarcaId(Long marcaId);
}