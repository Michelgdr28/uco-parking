package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain;

import java.util.UUID;

public final class AddVehicleDomain {

    private UUID   id;
    private String plate;
    private UUID   vehicleType;
    private UUID   customer;

    public AddVehicleDomain(String plate, UUID vehicleType, UUID customer) {
        super();
        regenerateId();
        setPlate(plate);
        setVehicleType(vehicleType);
        setCustomer(customer);
    }

    public void regenerateId() {
        generateId();
    }

    private void generateId() {
        this.id = UUID.randomUUID();
    }

    private void setPlate(String plate) {
        this.plate = plate;
    }

    private void setVehicleType(UUID vehicleType) {
        this.vehicleType = vehicleType;
    }

    private void setCustomer(UUID customer) {
        this.customer = customer;
    }

    public UUID getId() { 
    	return id;
    	}
    public String getPlate() { 
    	return plate;
    	}
    public UUID getVehicleType() { 
    	return vehicleType;
    	}
    public UUID getCustomer() { 
    	return customer; 
    	}
}