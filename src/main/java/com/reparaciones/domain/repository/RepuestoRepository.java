package com.reparaciones.domain.repository;

import java.util.List;
import java.util.Optional;

import com.reparaciones.domain.model.Repuesto;

public interface RepuestoRepository {
    List<Repuesto> findAll();
    Optional<Repuesto> findById(Long id);
    Repuesto save(Repuesto repuesto);
    void deleteById(Long id);
    List<Repuesto> findByNombre(String nombre);
    List<Repuesto> findBajoStock();
    Repuesto updateStock(Long id, Integer nuevoStock);
}