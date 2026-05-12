package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;
import co.edu.uco.ucoparking.crosscutting.helper.UUIDHelper;

public final class GetVehicleTypeDTO {

    private UUID id;
    private String name;

    public GetVehicleTypeDTO(UUID id, String name) {
        super();
        setId(id);
        setName(name);
    }

    public UUID getId() { 
    	return id;
    	}
    public String getName() { 
    	return name;
    	}

    private void setId(UUID id) {
        this.id = UUIDHelper.clean(id);
    }

    private void setName(String name) {
        this.name = TextHelper.clean(name);
    }
}
