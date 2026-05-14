package com.reparaciones.domain.repository;

import com.reparaciones.domain.enums.TipoReparacion;
import com.reparaciones.domain.model.Reparacion;

import java.util.List;
import java.util.Optional;

public interface ReparacionRepository {
    List<Reparacion> findAll();
    Optional<Reparacion> findById(Long id);
    Reparacion save(Reparacion reparacion);
    void deleteById(Long id);
    List<Reparacion> findByOrdenId(Long ordenId);
    List<Reparacion> findByOrdenIdAndTipo(Long ordenId, TipoReparacion tipo);
}