package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules;

public final class VehicleAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String userMessage;

    private VehicleAlreadyExistsException(String userMessage, String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static VehicleAlreadyExistsException create(String plate) {
        return new VehicleAlreadyExistsException(
            "Ya existe un vehículo registrado con la placa " + plate + ".",
            "AddVehicle: vehicle already exists with plate=" + plate
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}