package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.enums.TipoReparacion;
import com.reparaciones.infrastructure.persistence.entity.ReparacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReparacionJpaRepository extends JpaRepository<ReparacionEntity, Long> {
    List<ReparacionEntity> findByOrdenId(Long ordenId);
    List<ReparacionEntity> findByOrdenIdAndTipo(Long ordenId, TipoReparacion tipo);
}