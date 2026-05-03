package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.inputport.dto;

import java.util.UUID;

import co.edu.uco.ucoparking.features.vehicule.addvehicle.application.inputport.dto.validator.AddVehicleDTOValidator;

public class AddVehicleDTO {

    private String plate;
    private UUID vehicleType;
    private UUID owner;

    public AddVehicleDTO(String plate, UUID vehicleType, UUID owner) {
        super();
        setPlate(plate);
        setVehicleType(vehicleType);
        setOwner(owner);
    }

    String getPlate() {
        return plate;
    }

    UUID getVehicleType() {
        return vehicleType;
    }

    UUID getOwner() {
        return owner;
    }

    private void setPlate(String plate) {
        this.plate = AddVehicleDTOValidator.cleanAndValidatePlate(plate);
    }

    private void setVehicleType(UUID vehicleType) {
        AddVehicleDTOValidator.validateVehicleType(vehicleType);
        this.vehicleType = vehicleType;
    }

    private void setOwner(UUID owner) {
        AddVehicleDTOValidator.validateOwner(owner);
        this.owner = owner;
    }
}
