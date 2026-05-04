package com.reparaciones.infrastructure.persistence.mapper;

import com.reparaciones.domain.model.Cliente;
import com.reparaciones.infrastructure.persistence.entity.ClienteEntity;
import java.time.LocalDateTime;

public class ClienteMapper {

    public static Cliente toDomain(ClienteEntity entity) {
        if (entity == null) return null;
        Cliente cliente = new Cliente(entity.getId(), entity.getNombre(), entity.getTelefono(), entity.getEmail());
        cliente.setCreatedAt(entity.getCreatedAt());
        cliente.setUpdatedAt(entity.getUpdatedAt());
        cliente.setCreatedBy(entity.getCreatedBy());
        return cliente;
    }

    public static ClienteEntity toEntity(Cliente domain) {
        if (domain == null) return null;
        ClienteEntity entity = new ClienteEntity();
        entity.setId(domain.getId());
        entity.setNombre(domain.getNombre());
        entity.setTelefono(domain.getTelefono());
        entity.setEmail(domain.getEmail());
        entity.setCreatedAt(domain.getCreatedAt() != null ? domain.getCreatedAt() : LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        entity.setCreatedBy(domain.getCreatedBy());
        return entity;
    }
}