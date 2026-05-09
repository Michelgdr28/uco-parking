package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.CustomerRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper.CustomerEntityMapper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.CustomerJPARepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.CustomerJPAEntity;

public class CustomerJPARepositoryAdapter implements CustomerRepository{

	private CustomerJPARepository repository;
	
	public CustomerJPARepositoryAdapter(CustomerJPARepository repository) {
		this.repository = repository;
	}
	@Override
	public void create(CustomerEntity entity) {
		CustomerJPAEntity jpaEntity = CustomerEntityMapper.toJPA(entity);
		repository.save(jpaEntity);
	}
	@Override
	public void update(UUID id, CustomerEntity entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
	}
		@Override
	    public List<CustomerEntity> findAll() {
	        return repository.findAll()
	            .stream()
	            .map(CustomerEntityMapper::toEntity)
	            .toList();
	    }

	    @Override
	    public List<CustomerEntity> findByfilter(CustomerEntity filter) {
	        // TODO
	        return List.of();
	    }

	    @Override
	    public CustomerEntity findById(UUID id) {
	        return repository.findById(id)
	            .map(CustomerEntityMapper::toEntity)
	            .orElse(null);
	    }
	}
