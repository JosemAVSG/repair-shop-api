package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.infrastructure.persistence.entity.RepuestoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RepuestoJpaRepository extends JpaRepository<RepuestoEntity, Long> {
    List<RepuestoEntity> findByNombreContainingIgnoreCase(String nombre);
    
    @Query("SELECT r FROM RepuestoEntity r WHERE r.stockActual <= r.stockMinimo")
    List<RepuestoEntity> findBajoStock();
}