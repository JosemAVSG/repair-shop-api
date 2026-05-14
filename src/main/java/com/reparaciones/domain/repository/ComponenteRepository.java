package com.reparaciones.domain.repository;

import java.util.List;
import java.util.Optional;

import com.reparaciones.domain.model.Componente;

public interface ComponenteRepository {
    List<Componente> findAll();
    Optional<Componente> findById(Long id);
    Componente save(Componente componente);
    void deleteById(Long id);
    List<Componente> findByModeloId(Long modeloId);
}