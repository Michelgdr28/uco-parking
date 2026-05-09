package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules;

import java.util.UUID;

public final class VehicleTypeAlreadyAssignedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String userMessage;

    private VehicleTypeAlreadyAssignedException(String userMessage, String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static VehicleTypeAlreadyAssignedException create(UUID owner, UUID vehicleType) {
        return new VehicleTypeAlreadyAssignedException(
            "El propietario ya tiene registrado un vehículo de ese tipo.",
            "AddVehicle: owner=" + owner + " already has vehicleType=" + vehicleType
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}