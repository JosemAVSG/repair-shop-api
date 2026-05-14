package com.reparaciones.domain.repository;

import java.util.List;
import java.util.Optional;

import com.reparaciones.domain.model.Cliente;

public interface ClienteRepository {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    Optional<Cliente> findByTelefono(String telefono);
}