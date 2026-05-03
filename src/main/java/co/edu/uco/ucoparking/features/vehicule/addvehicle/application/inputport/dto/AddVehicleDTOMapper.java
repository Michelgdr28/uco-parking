package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.inputport.dto;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.features.vehicule.addvehicle.application.usecase.domain.AddVehicleDomain;

public final class AddVehicleDTOMapper {

    private AddVehicleDTOMapper() {
    }

    public static AddVehicleDomain toDomain(AddVehicleDTO dto) {
        if (dto == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del vehículo.",
                "AddVehicleDTOMapper.toDomain: dto is null");
        }
        return new AddVehicleDomain(dto.getPlate(), dto.getVehicleType(), dto.getOwner());
    }
}
