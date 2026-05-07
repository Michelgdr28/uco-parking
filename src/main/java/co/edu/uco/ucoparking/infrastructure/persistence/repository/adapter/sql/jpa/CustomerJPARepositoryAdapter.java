package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.CustomerRepository;
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
		//CustomerEntity -> CutomerJPAEntity(mapper)
		CustomerJPAEntity jpaEntity = null;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CustomerEntity> findByfilter(CustomerEntity filter) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CustomerEntity findById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
}
