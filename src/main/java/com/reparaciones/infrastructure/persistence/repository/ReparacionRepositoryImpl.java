package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Reparacion;
import com.reparaciones.domain.model.TipoReparacion;
import com.reparaciones.domain.repository.ReparacionRepository;
import com.reparaciones.infrastructure.persistence.mapper.ReparacionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReparacionRepositoryImpl implements ReparacionRepository {

    private final ReparacionJpaRepository jpaRepository;

    public ReparacionRepositoryImpl(ReparacionJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Reparacion> findAll() {
        return jpaRepository.findAll().stream().map(ReparacionMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Reparacion> findById(Long id) {
        return jpaRepository.findById(id).map(ReparacionMapper::toDomain);
    }

    @Override
    public Reparacion save(Reparacion reparacion) {
        return ReparacionMapper.toDomain(jpaRepository.save(ReparacionMapper.toEntity(reparacion)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Reparacion> findByOrdenId(Long ordenId) {
        return jpaRepository.findByOrdenId(ordenId).stream().map(ReparacionMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Reparacion> findByOrdenIdAndTipo(Long ordenId, TipoReparacion tipo) {
        return jpaRepository.findByOrdenIdAndTipo(ordenId, tipo).stream().map(ReparacionMapper::toDomain).collect(Collectors.toList());
    }
}