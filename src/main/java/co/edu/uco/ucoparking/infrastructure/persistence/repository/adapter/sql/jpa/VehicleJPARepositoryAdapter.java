package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;
import co.edu.uco.ucoparking.crosscutting.helper.UUIDHelper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.VehicleEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.VehicleJPARepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

@Repository
public class VehicleJPARepositoryAdapter implements VehicleRepository {

    private final VehicleJPARepository repository;
    private final VehicleEntityMapper mapper;

    public VehicleJPARepositoryAdapter(VehicleJPARepository repository,
                                       VehicleEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(VehicleEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se puede registrar un vehículo nulo.",
                "VehicleJPARepositoryAdapter.create: entity is null"
            );
        }
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, VehicleEntity entity) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del vehículo es obligatorio para actualizar.",
                "VehicleJPARepositoryAdapter.update: id is null"
            );
        }
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se puede actualizar un vehículo nulo.",
                "VehicleJPARepositoryAdapter.update: entity is null"
            );
        }
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void delete(UUID id) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del vehículo es obligatorio para eliminar.",
                "VehicleJPARepositoryAdapter.delete: id is null"
            );
        }
        repository.deleteById(id);
    }

    @Override
    public List<VehicleEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toEntity)
            .toList();
    }

    @Override
    public List<VehicleEntity> findByFilter(VehicleEntity filter) {
        if (ObjectHelper.isNull(filter)) {
            return findAll();
        }
        Specification<VehicleJPAEntity> spec = (root, query, cb) -> cb.conjunction();

        if (!TextHelper.isBlank(filter.getPlate())) {
            spec = spec.and((root, query, cb) ->
                cb.equal(root.get("plate"), filter.getPlate()));
        }
        if (!ObjectHelper.isNull(filter.getVehicleType())) {
            spec = spec.and((root, query, cb) ->
                cb.equal(root.get("vehicleType").get("id"),
                    filter.getVehicleType().getId()));
        }
        if (!ObjectHelper.isNull(filter.getOwner())) {
            spec = spec.and((root, query, cb) ->
                cb.equal(root.get("customer").get("id"),
                    filter.getOwner().getId()));
        }

        return repository.findAll(spec)
            .stream()
            .map(mapper::toEntity)
            .toList();
    }

    @Override
    public VehicleEntity findById(UUID id) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del vehículo es obligatorio para buscarlo.",
                "VehicleJPARepositoryAdapter.findById: id is null"
            );
        }
        return repository.findById(id)
            .map(mapper::toEntity)
            .orElse(null);
    }
}