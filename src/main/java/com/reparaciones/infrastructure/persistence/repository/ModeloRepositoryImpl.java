package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Modelo;
import com.reparaciones.domain.repository.ModeloRepository;
import com.reparaciones.infrastructure.persistence.mapper.ModeloMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ModeloRepositoryImpl implements ModeloRepository {

    private final ModeloJpaRepository jpaRepository;

    public ModeloRepositoryImpl(ModeloJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Modelo> findAll() {
        return jpaRepository.findAll().stream().map(ModeloMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Modelo> findById(Long id) {
        return jpaRepository.findById(id).map(ModeloMapper::toDomain);
    }

    @Override
    public Modelo save(Modelo modelo) {
        return ModeloMapper.toDomain(jpaRepository.save(ModeloMapper.toEntity(modelo)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Modelo> findByMarcaId(Long marcaId) {
        return jpaRepository.findByMarcaId(marcaId).stream().map(ModeloMapper::toDomain).collect(Collectors.toList());
    }
}