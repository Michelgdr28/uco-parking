package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport;

import java.util.List;

import co.edu.uco.ucoparking.application.inputport.InputPort;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto.GetVehicleTypeDTO;

public interface GetVehicleTypeInputPort extends InputPort<Void, List<GetVehicleTypeDTO>> {
}
