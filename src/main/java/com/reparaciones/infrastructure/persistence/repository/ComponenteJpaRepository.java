package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.infrastructure.persistence.entity.ComponenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComponenteJpaRepository extends JpaRepository<ComponenteEntity, Long> {
    List<ComponenteEntity> findByModeloId(Long modeloId);
}