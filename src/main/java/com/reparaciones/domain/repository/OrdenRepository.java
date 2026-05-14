package com.reparaciones.domain.repository;

import com.reparaciones.domain.enums.EstadoOrden;
import com.reparaciones.domain.model.OrdenTrabajo;

import java.util.List;
import java.util.Optional;

public interface OrdenRepository {
    List<OrdenTrabajo> findAll();
    Optional<OrdenTrabajo> findById(Long id);
    OrdenTrabajo save(OrdenTrabajo orden);
    void deleteById(Long id);
    List<OrdenTrabajo> findByClienteId(Long clienteId);
    List<OrdenTrabajo> findByEstado(EstadoOrden estado);
}