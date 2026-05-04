package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Modelo;
import com.reparaciones.infrastructure.persistence.entity.ModeloEntity;
import java.time.LocalDateTime;

public class ModeloMapper {

    public static Modelo toDomain(ModeloEntity entity) {
        if (entity == null) return null;
        Modelo modelo = new Modelo(entity.getId(), entity.getNombre(), entity.getMarcaId());
        modelo.setCreatedAt(entity.getCreatedAt());
        modelo.setUpdatedAt(entity.getUpdatedAt());
        modelo.setCreatedBy(entity.getCreatedBy());
        return modelo;
    }

    public static ModeloEntity toEntity(Modelo domain) {
        if (domain == null) return null;
        ModeloEntity entity = new ModeloEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setMarcaId(domain.getMarcaId());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}