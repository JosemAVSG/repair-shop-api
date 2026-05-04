package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.Componente;
import java.util.List;
import java.util.Optional;

public interface ComponenteRepository {
    List<Componente> findAll();
    Optional<Componente> findById(Long id);
    Componente save(Componente componente);
    void deleteById(Long id);
    List<Componente> findByModeloId(Long modeloId);
}