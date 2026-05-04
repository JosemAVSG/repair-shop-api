package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.Dispositivo;
import java.util.List;
import java.util.Optional;

public interface DispositivoRepository {
    List<Dispositivo> findAll();
    Optional<Dispositivo> findById(Long id);
    Dispositivo save(Dispositivo dispositivo);
    void deleteById(Long id);
    List<Dispositivo> findByClienteId(Long clienteId);
}