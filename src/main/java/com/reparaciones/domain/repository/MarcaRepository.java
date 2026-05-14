package com.reparaciones.domain.repository;

import java.util.List;
import java.util.Optional;

import com.reparaciones.domain.model.Marca;

public interface MarcaRepository {
    List<Marca> findAll();
    Optional<Marca> findById(Long id);
    Marca save(Marca marca);
    void deleteById(Long id);
    Optional<Marca> findByNombre(String nombre);
}