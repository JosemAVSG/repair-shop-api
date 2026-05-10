package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Repuesto;
import com.reparaciones.domain.repository.RepuestoRepository;
import com.reparaciones.infrastructure.persistence.mapper.RepuestoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepuestoRepositoryImpl implements RepuestoRepository {

    private final RepuestoJpaRepository jpaRepository;

    public RepuestoRepositoryImpl(RepuestoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Repuesto> findAll() {
        return jpaRepository.findAll().stream().map(RepuestoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Repuesto> findById(Long id) {
        return jpaRepository.findById(id).map(RepuestoMapper::toDomain);
    }

    @Override
    public Repuesto save(Repuesto repuesto) {
        return RepuestoMapper.toDomain(jpaRepository.save(RepuestoMapper.toEntity(repuesto)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Repuesto> findByNombre(String nombre) {
        return jpaRepository.findByNombreContainingIgnoreCase(nombre).stream().map(RepuestoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Repuesto> findBajoStock() {
        return jpaRepository.findBajoStock().stream().map(RepuestoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Repuesto updateStock(Long id, Integer nuevoStock) {
        return jpaRepository.findById(id).map(entity -> {
            entity.setStockActual(nuevoStock);
            return RepuestoMapper.toDomain(jpaRepository.save(entity));
        }).orElse(null);
    }
}