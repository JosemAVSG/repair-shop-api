package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Componente;
import com.reparaciones.infrastructure.persistence.entity.ComponenteEntity;
import java.time.LocalDateTime;

public class ComponenteMapper {

    public static Componente toDomain(ComponenteEntity entity) {
        if (entity == null) return null;
        Componente componente = new Componente(entity.getId(), entity.getNombre(), entity.getModeloId());
        componente.setCreatedAt(entity.getCreatedAt());
        componente.setUpdatedAt(entity.getUpdatedAt());
        componente.setCreatedBy(entity.getCreatedBy());
        return componente;
    }

    public static ComponenteEntity toEntity(Componente domain) {
        if (domain == null) return null;
        ComponenteEntity entity = new ComponenteEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setModeloId(domain.getModeloId());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}