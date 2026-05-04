package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.infrastructure.persistence.entity.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, Long> {
    Optional<MarcaEntity> findByNombre(String nombre);
}