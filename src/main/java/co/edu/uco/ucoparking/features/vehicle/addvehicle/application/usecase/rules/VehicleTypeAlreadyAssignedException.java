package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;

public final class VehicleTypeAlreadyAssignedException extends UcoParkingException {

    @Serial
    private static final long serialVersionUID = 1L;

    private VehicleTypeAlreadyAssignedException(String userMessage, String technicalMessage) {
        super(userMessage, technicalMessage, 409);
    }

    public static VehicleTypeAlreadyAssignedException create(UUID owner, UUID vehicleType) {
        return new VehicleTypeAlreadyAssignedException(
            "El propietario ya tiene registrado un vehículo de ese tipo.",
            "AddVehicle: owner=" + owner + " already has vehicleType=" + vehicleType
        );
    }
}