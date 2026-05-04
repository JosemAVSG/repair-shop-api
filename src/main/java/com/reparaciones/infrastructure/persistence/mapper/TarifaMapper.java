package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Tarifa;
import com.reparaciones.infrastructure.persistence.entity.TarifaEntity;
import java.time.LocalDateTime;

public class TarifaMapper {

    public static Tarifa toDomain(TarifaEntity entity) {
        if (entity == null) return null;
        Tarifa tarifa = new Tarifa(entity.getId(), entity.getMarcaId(), entity.getModeloId(), entity.getTipo(), entity.getPrecio());
        tarifa.setActiva(entity.isActiva());
        tarifa.setCreatedAt(entity.getCreatedAt());
        tarifa.setUpdatedAt(entity.getUpdatedAt());
        tarifa.setCreatedBy(entity.getCreatedBy());
        return tarifa;
    }

    public static TarifaEntity toEntity(Tarifa domain) {
        if (domain == null) return null;
        TarifaEntity entity = new TarifaEntity();
        entity.setId(domain.getId());
        entity.setMarcaId(domain.getMarcaId());
        entity.setModeloId(domain.getModeloId());
        entity.setTipo(domain.getTipo());
        entity.setPrecio(domain.getPrecio());
        entity.setActiva(domain.isActiva());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}