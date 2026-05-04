package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Reparacion;
import com.reparaciones.infrastructure.persistence.entity.ReparacionEntity;
import java.time.LocalDateTime;

public class ReparacionMapper {

    public static Reparacion toDomain(ReparacionEntity entity) {
        if (entity == null) return null;
        Reparacion reparacion = new Reparacion(entity.getId(), entity.getOrdenId(), entity.getTipo(), entity.getDescripcion(), entity.getPrecio());
        reparacion.setCreatedAt(entity.getCreatedAt());
        reparacion.setUpdatedAt(entity.getUpdatedAt());
        reparacion.setCreatedBy(entity.getCreatedBy());
        return reparacion;
    }

    public static ReparacionEntity toEntity(Reparacion domain) {
        if (domain == null) return null;
        ReparacionEntity entity = new ReparacionEntity();
        entity.setId(domain.getId());
        entity.setOrdenId(domain.getOrdenId());
        entity.setTipo(domain.getTipo());
        entity.setDescripcion(domain.getDescripcion());
        entity.setPrecio(domain.getPrecio());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}