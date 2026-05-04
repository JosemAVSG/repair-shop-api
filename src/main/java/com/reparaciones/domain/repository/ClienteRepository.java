package com.reparaciones.domain.repository;

import com.reparaciones.domain.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    Optional<Cliente> findByTelefono(String telefono);
}