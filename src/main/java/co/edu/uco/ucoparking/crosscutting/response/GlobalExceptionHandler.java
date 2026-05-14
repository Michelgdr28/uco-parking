package co.edu.uco.ucoparking.crosscutting.response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UcoParkingException.class)
    public ResponseEntity<ApiResponse<Void>> handleUcoParkingException(UcoParkingException ex) {
        return ResponseEntity
            .status(ex.getHttpStatus())
            .body(ApiResponse.error(ex.getHttpStatus(), ex.getUserMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {
        return ResponseEntity
            .status(500)
            .body(ApiResponse.error(500, "Ocurrió un error inesperado. Por favor intente más tarde."));
    }
}
