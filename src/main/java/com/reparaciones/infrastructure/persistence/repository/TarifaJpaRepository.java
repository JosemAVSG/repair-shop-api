package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.enums.TipoReparacion;
import com.reparaciones.infrastructure.persistence.entity.TarifaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TarifaJpaRepository extends JpaRepository<TarifaEntity, Long> {
    List<TarifaEntity> findByMarcaId(Long marcaId);
    List<TarifaEntity> findByModeloId(Long modeloId);
    Optional<TarifaEntity> findByModeloIdAndTipo(Long modeloId, TipoReparacion tipo);
    List<TarifaEntity> findByActivaTrue();
}