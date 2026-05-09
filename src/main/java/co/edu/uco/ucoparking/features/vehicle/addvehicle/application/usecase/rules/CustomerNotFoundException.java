package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules;

import java.util.UUID;

public final class CustomerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String userMessage;

    private CustomerNotFoundException(String userMessage, String technicalMessage) {
        super(technicalMessage);
        this.userMessage = userMessage;
    }

    public static CustomerNotFoundException create(UUID customerId) {
        return new CustomerNotFoundException(
            "No se encontró un cliente con el identificador proporcionado.",
            "AddVehicle: customer not found with id=" + customerId
        );
    }

    public String getUserMessage() {
        return userMessage;
    }
}