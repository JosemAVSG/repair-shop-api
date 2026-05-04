package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Dispositivo;
import com.reparaciones.infrastructure.persistence.entity.DispositivoEntity;
import java.time.LocalDateTime;

public class DispositivoMapper {

    public static Dispositivo toDomain(DispositivoEntity entity) {
        if (entity == null) return null;
        Dispositivo dispositivo = new Dispositivo(entity.getId(), entity.getModeloId(), entity.getClienteId());
        dispositivo.setNumeroSerie(entity.getNumeroSerie());
        dispositivo.setImei(entity.getImei());
        dispositivo.setNotasTecnicas(entity.getNotasTecnicas());
        dispositivo.setCreatedAt(entity.getCreatedAt());
        dispositivo.setUpdatedAt(entity.getUpdatedAt());
        dispositivo.setCreatedBy(entity.getCreatedBy());
        return dispositivo;
    }

    public static DispositivoEntity toEntity(Dispositivo domain) {
        if (domain == null) return null;
        DispositivoEntity entity = new DispositivoEntity();
        entity.setId(domain.getId());
        entity.setModeloId(domain.getModeloId());
        entity.setClienteId(domain.getClienteId());
        entity.setNumeroSerie(domain.getNumeroSerie());
        entity.setImei(domain.getImei());
        entity.setNotasTecnicas(domain.getNotasTecnicas());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}