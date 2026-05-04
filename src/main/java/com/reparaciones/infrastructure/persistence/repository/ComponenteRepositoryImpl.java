package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Componente;
import com.reparaciones.domain.repository.ComponenteRepository;
import com.reparaciones.infrastructure.persistence.mapper.ComponenteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ComponenteRepositoryImpl implements ComponenteRepository {

    private final ComponenteJpaRepository jpaRepository;

    public ComponenteRepositoryImpl(ComponenteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Componente> findAll() {
        return jpaRepository.findAll().stream().map(ComponenteMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Componente> findById(Long id) {
        return jpaRepository.findById(id).map(ComponenteMapper::toDomain);
    }

    @Override
    public Componente save(Componente componente) {
        return ComponenteMapper.toDomain(jpaRepository.save(ComponenteMapper.toEntity(componente)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Componente> findByModeloId(Long modeloId) {
        return jpaRepository.findByModeloId(modeloId).stream().map(ComponenteMapper::toDomain).collect(Collectors.toList());
    }
}