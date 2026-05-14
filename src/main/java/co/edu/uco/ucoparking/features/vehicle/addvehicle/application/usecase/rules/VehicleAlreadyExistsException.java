package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules;

import java.io.Serial;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;

public final class VehicleAlreadyExistsException extends UcoParkingException {

    @Serial
    private static final long serialVersionUID = 1L;

    private VehicleAlreadyExistsException(String userMessage, String technicalMessage) {
        super(userMessage, technicalMessage, 409);
    }

    public static VehicleAlreadyExistsException create(String plate) {
        return new VehicleAlreadyExistsException(
            "Ya existe un vehículo registrado con la placa " + plate + ".",
            "AddVehicle: vehicle already exists with plate=" + plate
        );
    }
}