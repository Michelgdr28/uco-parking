package co.edu.uco.ucoparking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

public interface VehicleTypeRepository {
	
    void create(VehicleTypeEntity entity);
    
    void update(UUID id, VehicleTypeEntity entity);
    
    void delete(UUID id);
    
    List<VehicleTypeEntity> findAll();
    
    List<VehicleTypeEntity> findByFilter(VehicleTypeEntity filter);
    
    VehicleTypeEntity findById(UUID id);
}
