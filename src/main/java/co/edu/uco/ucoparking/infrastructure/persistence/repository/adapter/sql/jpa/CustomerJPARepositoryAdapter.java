package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.CustomerRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.CustomerEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.CustomerJPARepository;

@Repository
public class CustomerJPARepositoryAdapter implements CustomerRepository {

    private final CustomerJPARepository repository;
    private final CustomerEntityMapper mapper;

    public CustomerJPARepositoryAdapter(CustomerJPARepository repository,
                                        CustomerEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void create(CustomerEntity entity) {
        repository.save(mapper.toJPA(entity));
    }

    @Override
    public void update(UUID id, CustomerEntity entity) {
        // TODO
    }

    @Override
    public void delete(UUID id) {
        // TODO
    }

    @Override
    public List<CustomerEntity> findAll() {
        return mapper.toEntityList(repository.findAll());
    }

    @Override
    public List<CustomerEntity> findByFilter(CustomerEntity filter) {
        // TODO
        return List.of();
    }

    @Override
    public CustomerEntity findById(UUID id) {
        return repository.findById(id)
            .map(mapper::toEntity)
            .orElse(null);
    }
}