package co.edu.uco.ucoparking.crosscutting.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules.CustomerNotFoundException;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules.VehicleAlreadyExistsException;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules.VehicleTypeAlreadyAssignedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomerNotFound(CustomerNotFoundException ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiResponse.error(404, ex.getUserMessage()));
    }

    @ExceptionHandler(VehicleAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Void>> handleVehicleAlreadyExists(VehicleAlreadyExistsException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ApiResponse.error(409, ex.getUserMessage()));
    }

    @ExceptionHandler(VehicleTypeAlreadyAssignedException.class)
    public ResponseEntity<ApiResponse<Void>> handleVehicleTypeAlreadyAssigned(VehicleTypeAlreadyAssignedException ex) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ApiResponse.error(409, ex.getUserMessage()));
    }

    @ExceptionHandler(UcoParkingException.class)
    public ResponseEntity<ApiResponse<Void>> handleUcoParkingException(UcoParkingException ex) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse.error(400, ex.getUserMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse.error(500, "Ocurrió un error inesperado. Por favor intente más tarde."));
    }
}
