package co.edu.uco.ucoparking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;

public interface CustomerRepository {
	
    void create(CustomerEntity entity);
    
    void update(UUID id, CustomerEntity entity);
    
    void delete(UUID id);
    
    List<CustomerEntity> findAll();
    
    List<CustomerEntity> findByFilter(CustomerEntity filter);  
    
    CustomerEntity findById(UUID id);
}
