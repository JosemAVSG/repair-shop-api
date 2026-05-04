package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.OrdenTrabajo;
import com.reparaciones.infrastructure.persistence.entity.OrdenEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenMapper {

    public static OrdenTrabajo toDomain(OrdenEntity entity) {
        if (entity == null) return null;
        OrdenTrabajo orden = new OrdenTrabajo(entity.getId(), entity.getClienteId(), entity.getDispositivoId(), entity.getEstado());
        orden.setFalloReportado(entity.getFalloReportado());
        orden.setPrecioTotal(entity.getPrecioTotal());
        orden.setFechaEntrada(entity.getFechaEntrada());
        orden.setFechaSalida(entity.getFechaSalida());
        orden.setNotas(entity.getNotas());
        orden.setCreatedAt(entity.getCreatedAt());
        orden.setUpdatedAt(entity.getUpdatedAt());
        orden.setCreatedBy(entity.getCreatedBy());
        return orden;
    }

    public static OrdenEntity toEntity(OrdenTrabajo domain) {
        if (domain == null) return null;
        OrdenEntity entity = new OrdenEntity();
        entity.setId(domain.getId());
        entity.setClienteId(domain.getClienteId());
        entity.setDispositivoId(domain.getDispositivoId());
        entity.setEstado(domain.getEstado());
        entity.setFalloReportado(domain.getFalloReportado());
        entity.setPrecioTotal(domain.getPrecioTotal());
        entity.setFechaEntrada(domain.getFechaEntrada() != null ? domain.getFechaEntrada() : LocalDateTime.now());
        entity.setFechaSalida(domain.getFechaSalida());
        entity.setNotas(domain.getNotas());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}