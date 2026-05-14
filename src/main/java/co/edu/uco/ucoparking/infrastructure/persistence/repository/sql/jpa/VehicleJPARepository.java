package co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

public interface VehicleJPARepository extends JpaRepository<VehicleJPAEntity, UUID>,
            JpaSpecificationExecutor<VehicleJPAEntity> {
    List<VehicleJPAEntity> findByPlate(String plate);
    List<VehicleJPAEntity> findByCustomerIdAndVehicleTypeId(UUID customerId, UUID vehicleTypeId);
}
