package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleTypeRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.VehicleTypeEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.VehicleTypeJPARepository;

@Repository
public class VehicleTypeJPARepositoryAdapter implements VehicleTypeRepository {

    private final VehicleTypeJPARepository repository;
    private final VehicleTypeEntityMapper mapper;

    public VehicleTypeJPARepositoryAdapter(VehicleTypeJPARepository repository,
                                           VehicleTypeEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(VehicleTypeEntity entity) {
        repository.save(mapper.toJPA(entity));
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
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public List<VehicleTypeEntity> findByFilter(VehicleTypeEntity filter) {
        // TODO
        return List.of();
    }

    @Override
    public VehicleTypeEntity findById(UUID id) {
        return repository.findById(id)
            .map(mapper::toEntity)
            .orElse(null);
    }
}