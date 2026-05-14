package co.edu.uco.ucoparking.features.vehicletype.getvehicletypebyid.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;

public final class VehicleTypeNotFoundException extends UcoParkingException {

    @Serial
    private static final long serialVersionUID = 1L;

    private VehicleTypeNotFoundException(String userMessage, String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static VehicleTypeNotFoundException create(UUID vehicleTypeId) {
        return new VehicleTypeNotFoundException(
            "El tipo de vehículo no existe.",
            "GetVehicleTypeById: vehicleType not found with id=" + vehicleTypeId
        );
    }
}
