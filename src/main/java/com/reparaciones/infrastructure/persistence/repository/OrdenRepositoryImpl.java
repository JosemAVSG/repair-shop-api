package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.enums.EstadoOrden;
import com.reparaciones.domain.model.OrdenTrabajo;
import com.reparaciones.domain.repository.OrdenRepository;
import com.reparaciones.infrastructure.persistence.mapper.OrdenMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrdenRepositoryImpl implements OrdenRepository {

    private final OrdenJpaRepository jpaRepository;

    public OrdenRepositoryImpl(OrdenJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<OrdenTrabajo> findAll() {
        return jpaRepository.findAll().stream().map(OrdenMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return jpaRepository.findById(id).map(OrdenMapper::toDomain);
    }

    @Override
    public OrdenTrabajo save(OrdenTrabajo orden) {
        return OrdenMapper.toDomain(jpaRepository.save(OrdenMapper.toEntity(orden)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<OrdenTrabajo> findByClienteId(Long clienteId) {
        return jpaRepository.findByClienteId(clienteId).stream().map(OrdenMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<OrdenTrabajo> findByEstado(EstadoOrden estado) {
        return jpaRepository.findByEstado(estado).stream().map(OrdenMapper::toDomain).collect(Collectors.toList());
    }
}