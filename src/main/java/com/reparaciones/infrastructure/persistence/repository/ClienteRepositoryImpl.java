package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.model.Cliente;
import com.reparaciones.domain.repository.ClienteRepository;
import com.reparaciones.infrastructure.persistence.entity.ClienteEntity;
import com.reparaciones.infrastructure.persistence.mapper.ClienteMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteJpaRepository jpaRepository;

    public ClienteRepositoryImpl(ClienteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Cliente> findAll() {
        return jpaRepository.findAll().stream()
                .map(ClienteMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return jpaRepository.findById(id).map(ClienteMapper::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity saved = jpaRepository.save(ClienteMapper.toEntity(cliente));
        return ClienteMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> findByTelefono(String telefono) {
        return jpaRepository.findByTelefono(telefono).map(ClienteMapper::toDomain);
    }
}