package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleTypeRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.VehicleTypeEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.VehicleTypeJPARepository;

public class VehicleTypeJPARepositoryAdapter implements VehicleTypeRepository {

    private VehicleTypeJPARepository repository;

    public VehicleTypeJPARepositoryAdapter(VehicleTypeJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(VehicleTypeEntity entity) {
        repository.save(VehicleTypeEntityMapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, VehicleTypeEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        // TODO
    }

    @Override
    public List<VehicleTypeEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(VehicleTypeEntityMapper::toEntity)
            .toList();
    }

    @Override
    public List<VehicleTypeEntity> findByFilter(VehicleTypeEntity filter) {
        // TODO
        return List.of();
    }

    @Override
    public VehicleTypeEntity findById(UUID id) {
        return repository.findById(id)
            .map(VehicleTypeEntityMapper::toEntity)
            .orElse(null);
    }
}
