package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.ucoparking.crosscutting.response.ApiResponse;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.GetVehicleTypeInputPort;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto.GetVehicleTypeDTO;

@RestController
@RequestMapping("/api/v1/vehicle-types")
public class GetVehicleTypeController {

    private final GetVehicleTypeInputPort inputPort;

    public GetVehicleTypeController(GetVehicleTypeInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<GetVehicleTypeDTO>>> getAll() {
        List<GetVehicleTypeDTO> vehicleTypes = inputPort.execute(null);
        return ResponseEntity.ok(
            ApiResponse.ok("Tipos de vehículo obtenidos exitosamente.", vehicleTypes)
        );
    }
}
