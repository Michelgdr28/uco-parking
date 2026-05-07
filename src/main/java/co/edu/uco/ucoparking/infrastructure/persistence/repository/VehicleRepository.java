package co.edu.uco.ucoparking.infrastructure.persistence.repository;

import java.util.List;
import java.util.UUID;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;

public interface VehicleRepository {
	
	void create(VehicleEntity vehicle);
	
	void update(UUID id, VehicleEntity entity);
	
	void delete(UUID id);
	
	List<VehicleEntity> findAll();
	
	List <VehicleEntity> findByFilter(VehicleEntity filter);
	
	VehicleEntity findById(UUID id);

}
