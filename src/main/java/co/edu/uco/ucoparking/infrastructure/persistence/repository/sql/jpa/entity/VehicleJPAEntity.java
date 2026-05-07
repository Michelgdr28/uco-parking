package co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleJPAEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "plate")
	private String plate;
	
	@Column(name = "vehicle_type_id")
	private VehicleTypeJPAEntity vehicleType;
	
	@Column(name = "customer_id")
	private CustomerJPAEntity customer;
	
	public VehicleJPAEntity(UUID id, String plate, VehicleTypeJPAEntity vehicleType, CustomerJPAEntity customer) {
		super();
		setId(id);
		setPlate(plate);
		setVehicleType(vehicleType);
		setCustomer(customer);
	}
	public UUID getId() {
		return id;
	}
	public String getPlate() {
		return plate;
	}
	public VehicleTypeJPAEntity getVehicleType() {
		return vehicleType;
	}
	public CustomerJPAEntity getCustomer() {
		return customer;
	}
	private void setId(UUID id) {
		this.id = id;
	}
	private void setPlate(String plate) {
		this.plate = plate;
	}
	private void setVehicleType(VehicleTypeJPAEntity vehicleType) {
		this.vehicleType = vehicleType;
	}
}
