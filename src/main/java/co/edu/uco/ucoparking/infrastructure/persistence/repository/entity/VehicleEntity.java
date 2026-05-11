package co.edu.uco.ucoparking.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;

public class VehicleEntity {
	private UUID id;
	private String Plate;
	private VehicleTypeEntity vehicleType;
	private CustomerEntity owner;

	public VehicleEntity(UUID id, String plate, VehicleTypeEntity vehicleType, CustomerEntity owner) {
		super();
		setId (id);
		setPlate(plate);
		setVehicleType(vehicleType);
		setCustomer(owner);
	}
	public UUID getId() {
		return id;
	}
	public String getPlate() {
		return Plate;
	}
	public VehicleTypeEntity getVehicleType() {
		return vehicleType;
	}
	public CustomerEntity getOwner() {
		return owner;
	}
	private void setId(UUID id) {
		this.id = id;
	}
	private void setPlate(String plate) {
		this.Plate = TextHelper.cleanAndUpperCase(plate);
	}
	private void setVehicleType(VehicleTypeEntity vehicleType) {
		this.vehicleType = vehicleType;
	}
	private void setCustomer(CustomerEntity owner) {
		this.owner = owner;
	}
}
