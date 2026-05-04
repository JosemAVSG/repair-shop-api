package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Marca;
import com.reparaciones.domain.repository.MarcaRepository;
import com.reparaciones.infrastructure.persistence.mapper.MarcaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MarcaRepositoryImpl implements MarcaRepository {

    private final MarcaJpaRepository jpaRepository;

    public MarcaRepositoryImpl(MarcaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Marca> findAll() {
        return jpaRepository.findAll().stream()
                .map(MarcaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Marca> findById(Long id) {
        return jpaRepository.findById(id).map(MarcaMapper::toDomain);
    }

    @Override
    public Marca save(Marca marca) {
        return MarcaMapper.toDomain(jpaRepository.save(MarcaMapper.toEntity(marca)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Marca> findByNombre(String nombre) {
        return jpaRepository.findByNombre(nombre).map(MarcaMapper::toDomain);
    }
}