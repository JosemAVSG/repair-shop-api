package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.infrastructure.persistence.entity.DispositivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DispositivoJpaRepository extends JpaRepository<DispositivoEntity, Long> {
    List<DispositivoEntity> findByClienteId(Long clienteId);
}