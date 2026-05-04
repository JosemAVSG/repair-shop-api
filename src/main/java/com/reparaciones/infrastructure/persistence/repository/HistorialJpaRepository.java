package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.infrastructure.persistence.entity.HistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialJpaRepository extends JpaRepository<HistorialEntity, Long> {
    List<HistorialEntity> findByEntidadTipoAndEntidadId(String entidadTipo, Long entidadId);
}