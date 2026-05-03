package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.usecase.domain;

import java.util.UUID;

public class AddVehicleDomain {

	private UUID id;
	private String plate;
	private UUID vehicleType;
	private UUID owner;
	
	public AddVehicleDomain(String plate, UUID vehicleType, UUID owner) {
		super();
		generateId(owner);
		setPlate(plate);
		setVehicleType(vehicleType);
		setOwner(owner);
	}	
	
	private void generateId(UUID id) {
		this.id = UUID.randomUUID();
	}
	
	public void generateId() {
		this.id= UUID.randomUUID();
	}
	private String getPlate() {
		return plate;
	}
	private void setPlate(String plate) {
		this.plate = plate;
	}
	private UUID getVehicleType() {
		return vehicleType;
	}
	private void setVehicleType(UUID vehicleType) {
		this.vehicleType = vehicleType;
	}
	private UUID getOwner() {
		return owner;
	}
	private void setOwner(UUID owner) {
		this.owner = owner;
	}
	
	
}
