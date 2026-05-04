package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.HistorialEntrada;
import com.reparaciones.infrastructure.persistence.entity.HistorialEntity;
import java.time.LocalDateTime;

public class HistorialMapper {

    public static HistorialEntrada toDomain(HistorialEntity entity) {
        if (entity == null) return null;
        HistorialEntrada entrada = new HistorialEntrada(entity.getEntidadTipo(), entity.getEntidadId(), entity.getContenido());
        entrada.setId(entity.getId());
        entrada.setCreatedAt(entity.getCreatedAt());
        entrada.setCreatedBy(entity.getCreatedBy());
        return entrada;
    }

    public static HistorialEntity toEntity(HistorialEntrada domain) {
        if (domain == null) return null;
        HistorialEntity entity = new HistorialEntity();
        entity.setId(domain.getId());
        entity.setEntidadTipo(domain.getEntidadTipo());
        entity.setEntidadId(domain.getEntidadId());
        entity.setContenido(domain.getContenido());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}