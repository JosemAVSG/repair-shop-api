package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.enums.EstadoOrden;
import com.reparaciones.infrastructure.persistence.entity.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrdenJpaRepository extends JpaRepository<OrdenEntity, Long> {
    List<OrdenEntity> findByClienteId(Long clienteId);
    List<OrdenEntity> findByEstado(EstadoOrden estado);
}