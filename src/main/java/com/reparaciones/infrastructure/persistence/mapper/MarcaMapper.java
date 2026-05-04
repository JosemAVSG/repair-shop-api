package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Marca;
import com.reparaciones.infrastructure.persistence.entity.MarcaEntity;
import java.time.LocalDateTime;

public class MarcaMapper {

    public static Marca toDomain(MarcaEntity entity) {
        if (entity == null) return null;
        Marca marca = new Marca(entity.getId(), entity.getNombre());
        marca.setCreatedAt(entity.getCreatedAt());
        marca.setUpdatedAt(entity.getUpdatedAt());
        marca.setCreatedBy(entity.getCreatedBy());
        return marca;
    }

    public static MarcaEntity toEntity(Marca domain) {
        if (domain == null) return null;
        MarcaEntity entity = new MarcaEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}