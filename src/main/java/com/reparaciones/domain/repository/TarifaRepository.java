package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.Tarifa;
import com.reparaciones.domain.model.TipoReparacion;
import java.util.List;
import java.util.Optional;

public interface TarifaRepository {
    List<Tarifa> findAll();
    Optional<Tarifa> findById(Long id);
    Tarifa save(Tarifa tarifa);
    void deleteById(Long id);
    List<Tarifa> findByMarcaId(Long marcaId);
    List<Tarifa> findByModeloId(Long modeloId);
    Optional<Tarifa> findByModeloIdAndTipo(Long modeloId, TipoReparacion tipo);
    List<Tarifa> findByActivaTrue();
}