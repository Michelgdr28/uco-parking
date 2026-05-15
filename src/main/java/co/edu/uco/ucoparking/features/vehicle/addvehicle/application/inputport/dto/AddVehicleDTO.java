package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddVehicleDTO {

    private String plate;
    private UUID vehicleType;
    private UUID owner;

    @JsonCreator
    public AddVehicleDTO(
            @JsonProperty("plate")       String plate,
            @JsonProperty("vehicleType") UUID vehicleType,
            @JsonProperty("owner")       UUID owner) {
        setPlate(plate);
        setVehicleType(vehicleType);
        setOwner(owner);
    }

    public String getPlate() {
    	return plate;
    	}
    public UUID getVehicleType() {
    	return vehicleType;
    	}
    public UUID getOwner() {
    	return owner;
    	}

    public void setPlate(String plate) { 
    	this.plate = plate; 
    	}
    private void setVehicleType(UUID vehicleType) {
    	this.vehicleType = vehicleType;
    	}
    private void setOwner(UUID owner) { 
    	this.owner = owner;
    	}
}