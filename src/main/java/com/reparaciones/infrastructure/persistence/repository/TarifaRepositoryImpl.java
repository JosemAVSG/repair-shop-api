package com.reparaciones.infrastructure.persistence.repository;

import com.reparaciones.domain.enums.TipoReparacion;
import com.reparaciones.domain.model.Tarifa;
import com.reparaciones.domain.repository.TarifaRepository;
import com.reparaciones.infrastructure.persistence.mapper.TarifaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TarifaRepositoryImpl implements TarifaRepository {

    private final TarifaJpaRepository jpaRepository;

    public TarifaRepositoryImpl(TarifaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Tarifa> findAll() {
        return jpaRepository.findAll().stream().map(TarifaMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Tarifa> findById(Long id) {
        return jpaRepository.findById(id).map(TarifaMapper::toDomain);
    }

    @Override
    public Tarifa save(Tarifa tarifa) {
        return TarifaMapper.toDomain(jpaRepository.save(TarifaMapper.toEntity(tarifa)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Tarifa> findByMarcaId(Long marcaId) {
        return jpaRepository.findByMarcaId(marcaId).stream().map(TarifaMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Tarifa> findByModeloId(Long modeloId) {
        return jpaRepository.findByModeloId(modeloId).stream().map(TarifaMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Tarifa> findByModeloIdAndTipo(Long modeloId, TipoReparacion tipo) {
        return jpaRepository.findByModeloIdAndTipo(modeloId, tipo).map(TarifaMapper::toDomain);
    }

    @Override
    public List<Tarifa> findByActivaTrue() {
        return jpaRepository.findByActivaTrue().stream().map(TarifaMapper::toDomain).collect(Collectors.toList());
    }
}