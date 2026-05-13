package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;
import co.edu.uco.ucoparking.crosscutting.helper.UUIDHelper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.CustomerRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.CustomerEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.CustomerJPARepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.CustomerJPAEntity;

@Repository
public class CustomerJPARepositoryAdapter implements CustomerRepository {

    private final CustomerJPARepository repository;
    private final CustomerEntityMapper mapper;

    public CustomerJPARepositoryAdapter(CustomerJPARepository repository,CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(CustomerEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se puede registrar un cliente nulo.",
                "CustomerJPARepositoryAdapter.create: entity is null"
            );
        }
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, CustomerEntity entity) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del cliente es obligatorio para actualizar.",
                "CustomerJPARepositoryAdapter.update: id is null"
            );
        }
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se puede actualizar un cliente nulo.",
                "CustomerJPARepositoryAdapter.update: entity is null"
            );
        }
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void delete(UUID id) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del cliente es obligatorio para eliminar.",
                "CustomerJPARepositoryAdapter.delete: id is null"
            );
        }
        repository.deleteById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return repository.findAll()
            .stream()
            .map(mapper::toEntity)
            .toList();
    }

    @Override
    public List<CustomerEntity> findByfilter(CustomerEntity filter) {
        if (ObjectHelper.isNull(filter)) {
            return findAll();
        }
        Specification<CustomerJPAEntity> spec = (root, query, cb) -> cb.conjunction();

        if (!TextHelper.isBlank(filter.getIdNumber())) {
            spec = spec.and((root, query, cb) ->
                cb.equal(root.get("idNumber"), filter.getIdNumber()));
        }
        if (!TextHelper.isBlank(filter.getName())) {
            spec = spec.and((root, query, cb) ->
                cb.like(cb.lower(root.get("name")),
                    "%" + filter.getName().toLowerCase() + "%"));
        }
        if (!TextHelper.isBlank(filter.getEmail())) {
            spec = spec.and((root, query, cb) ->
                cb.equal(root.get("email"), filter.getEmail()));
        }

        return repository.findAll(spec)
            .stream()
            .map(mapper::toEntity)
            .toList();
    }

    @Override
    public CustomerEntity findById(UUID id) {
        if (UUIDHelper.isNull(id)) {
            throw UcoParkingException.create(
                "El identificador del cliente es obligatorio para buscarlo.",
                "CustomerJPARepositoryAdapter.findById: id is null"
            );
        }
        return repository.findById(id)
            .map(mapper::toEntity)
            .orElse(null);
    }
}
