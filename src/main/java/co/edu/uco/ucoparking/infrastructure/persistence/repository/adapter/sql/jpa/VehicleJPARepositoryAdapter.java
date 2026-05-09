package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.VehicleEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.VehicleJPARepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

public class VehicleJPARepositoryAdapter implements VehicleRepository {

    private VehicleJPARepository repository;

    public VehicleJPARepositoryAdapter(VehicleJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(VehicleEntity entity) {
        VehicleJPAEntity jpaEntity = VehicleEntityMapper.toJPA(entity);
        repository.save(jpaEntity);
    }

    @Override
    public void update(UUID id, VehicleEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        // TODO
    }

    @Override
    public List<VehicleEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(VehicleEntityMapper::toEntity)
            .toList();
    }

    @Override
    public List<VehicleEntity> findByFilter(VehicleEntity filter) {
        // TODO
        return List.of();
    }

    @Override
    public VehicleEntity findById(UUID id) {
        return repository.findById(id)
            .map(VehicleEntityMapper::toEntity)
            .orElse(null);
    }
}
