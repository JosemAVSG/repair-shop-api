package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Dispositivo;
import com.reparaciones.domain.repository.DispositivoRepository;
import com.reparaciones.infrastructure.persistence.mapper.DispositivoMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DispositivoRepositoryImpl implements DispositivoRepository {

    private final DispositivoJpaRepository jpaRepository;

    public DispositivoRepositoryImpl(DispositivoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Dispositivo> findAll() {
        return jpaRepository.findAll().stream().map(DispositivoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Dispositivo> findById(Long id) {
        return jpaRepository.findById(id).map(DispositivoMapper::toDomain);
    }

    @Override
    public Dispositivo save(Dispositivo dispositivo) {
        return DispositivoMapper.toDomain(jpaRepository.save(DispositivoMapper.toEntity(dispositivo)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Dispositivo> findByClienteId(Long clienteId) {
        return jpaRepository.findByClienteId(clienteId).stream().map(DispositivoMapper::toDomain).collect(Collectors.toList());
    }
}