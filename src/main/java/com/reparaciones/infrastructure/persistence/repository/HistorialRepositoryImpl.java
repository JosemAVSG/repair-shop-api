package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.HistorialEntrada;
import com.reparaciones.domain.repository.HistorialRepository;
import com.reparaciones.infrastructure.persistence.mapper.HistorialMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HistorialRepositoryImpl implements HistorialRepository {

    private final HistorialJpaRepository jpaRepository;

    public HistorialRepositoryImpl(HistorialJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<HistorialEntrada> findAll() {
        return jpaRepository.findAll().stream().map(HistorialMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public HistorialEntrada save(HistorialEntrada entrada) {
        return HistorialMapper.toDomain(jpaRepository.save(HistorialMapper.toEntity(entrada)));
    }

    @Override
    public List<HistorialEntrada> findByEntidadTipoAndEntidadId(String entidadTipo, Long entidadId) {
        return jpaRepository.findByEntidadTipoAndEntidadId(entidadTipo, entidadId)
                .stream().map(HistorialMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}