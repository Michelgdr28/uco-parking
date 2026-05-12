package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto;

import java.util.UUID;

public final class GetVehicleTypeDTO {

    private UUID id;
    private String name;

    public GetVehicleTypeDTO(UUID id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public UUID getId() { 
    	return id;
    	}
    public String getName() { 
    	return name; 
    	}
}
