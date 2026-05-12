package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.mapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;

public final class AddVehicleDTOMapper {

    private AddVehicleDTOMapper() {
    }

    public static AddVehicleDomain toDomain(AddVehicleDTO dto) {
        if (ObjectHelper.isNull(dto)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del vehículo.",
                "AddVehicleDTOMapper.toDomain: dto is null");
        }
        return new AddVehicleDomain(dto.getPlate(), dto.getVehicleType(), dto.getOwner());
    }
}