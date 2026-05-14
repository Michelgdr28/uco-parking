package co.edu.uco.ucoparking.features.customer.getcustomerbyid.application.usecase.rules;

import java.io.Serial;
import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;

public final class CustomerNotFoundException extends UcoParkingException {

    @Serial
    private static final long serialVersionUID = 1L;

    private CustomerNotFoundException(String userMessage, String technicalMessage) {
        super(userMessage, technicalMessage, 404);
    }

    public static CustomerNotFoundException create(UUID customerId) {
        return new CustomerNotFoundException(
            "El cliente no existe.",
            "GetCustomerById: customer not found with id=" + customerId
        );
    }
}