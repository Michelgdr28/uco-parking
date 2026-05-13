package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;
import co.edu.uco.ucoparking.crosscutting.helper.UUIDHelper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleTypeRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.VehicleTypeEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.VehicleTypeJPARepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleTypeJPAEntity;

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
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se puede registrar un tipo de vehículo nulo.",
                "VehicleTypeJPARepositoryAdapter.create: entity is null"
            );
        }
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, VehicleTypeEntity entity) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del tipo de vehículo es obligatorio para actualizar.",
                "VehicleTypeJPARepositoryAdapter.update: id is null"
            );
        }
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se puede actualizar un tipo de vehículo nulo.",
                "VehicleTypeJPARepositoryAdapter.update: entity is null"
            );
        }
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void delete(UUID id) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del tipo de vehículo es obligatorio para eliminar.",
                "VehicleTypeJPARepositoryAdapter.delete: id is null"
            );
        }
        repository.deleteById(id);
    }

    @Override
    public List<VehicleTypeEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toEntity)
            .toList();
    }

    @Override
    public List<VehicleTypeEntity> findByFilter(VehicleTypeEntity filter) {
        if (ObjectHelper.isNull(filter)) {
            return findAll();
        }
        Specification<VehicleTypeJPAEntity> spec = (root, query, cb) -> cb.conjunction();

        if (!TextHelper.isBlank(filter.getName())) {
            spec = spec.and((root, query, cb) ->
                cb.like(cb.lower(root.get("name")),
                    "%" + filter.getName().toLowerCase() + "%"));
        }

        return repository.findAll(spec)
            .stream()
            .map(mapper::toEntity)
            .toList();
    }

    @Override
    public VehicleTypeEntity findById(UUID id) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del tipo de vehículo es obligatorio para buscarlo.",
                "VehicleTypeJPARepositoryAdapter.findById: id is null"
            );
        }
        return repository.findById(id)
            .map(mapper::toEntity)
            .orElse(null);
    }
}
