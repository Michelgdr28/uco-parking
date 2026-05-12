package co.edu.uco.ucoparking.features.vehicle.addvehicle.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucoparking.crosscutting.response.ApiResponse;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.AddVehicleInputPort;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;

@RestController
@RequestMapping("/api/v1/vehicles")
public class AddVehicleController {

    private final AddVehicleInputPort inputPort;

    public AddVehicleController(AddVehicleInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> add(@RequestBody AddVehicleDTO dto) {
        inputPort.execute(dto);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ApiResponse.created("Vehículo registrado exitosamente.", null));
    }
}