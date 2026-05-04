package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.Marca;
import java.util.List;
import java.util.Optional;

public interface MarcaRepository {
    List<Marca> findAll();
    Optional<Marca> findById(Long id);
    Marca save(Marca marca);
    void deleteById(Long id);
    Optional<Marca> findByNombre(String nombre);
}