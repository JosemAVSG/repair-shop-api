package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Repuesto;
import com.reparaciones.infrastructure.persistence.entity.RepuestoEntity;
import java.time.LocalDateTime;

public class RepuestoMapper {

    public static Repuesto toDomain(RepuestoEntity entity) {
        if (entity == null) return null;
        Repuesto repuesto = new Repuesto();
        repuesto.setId(entity.getId());
        repuesto.setNombre(entity.getNombre());
        repuesto.setDescripcion(entity.getDescripcion());
        repuesto.setCodigo(entity.getCodigo());
        repuesto.setPrecioCosto(entity.getPrecioCosto());
        repuesto.setPrecioVenta(entity.getPrecioVenta());
        repuesto.setStockActual(entity.getStockActual());
        repuesto.setStockMinimo(entity.getStockMinimo());
        repuesto.setProveedorId(entity.getProveedorId());
        repuesto.setCreatedAt(entity.getCreatedAt());
        repuesto.setUpdatedAt(entity.getUpdatedAt());
        repuesto.setCreatedBy(entity.getCreatedBy());
        return repuesto;
    }

    public static RepuestoEntity toEntity(Repuesto domain) {
        if (domain == null) return null;
        RepuestoEntity entity = new RepuestoEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setDescripcion(domain.getDescripcion());
        entity.setCodigo(domain.getCodigo());
        entity.setPrecioCosto(domain.getPrecioCosto());
        entity.setPrecioVenta(domain.getPrecioVenta());
        entity.setStockActual(domain.getStockActual());
        entity.setStockMinimo(domain.getStockMinimo());
        entity.setProveedorId(domain.getProveedorId());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}