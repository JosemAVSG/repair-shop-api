package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.infrastructure.persistence.entity.ModeloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ModeloJpaRepository extends JpaRepository<ModeloEntity, Long> {
    List<ModeloEntity> findByMarcaId(Long marcaId);
}