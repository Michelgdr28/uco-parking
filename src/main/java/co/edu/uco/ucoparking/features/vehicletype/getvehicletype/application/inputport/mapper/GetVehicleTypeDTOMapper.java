package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.mapper;

import java.util.List;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto.GetVehicleTypeDTO;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain.GetVehicleTypeDomain;

public final class GetVehicleTypeDTOMapper {

    private GetVehicleTypeDTOMapper() {
    }

    public static GetVehicleTypeDTO toDTO(GetVehicleTypeDomain domain) {
        if (ObjectHelper.isNull(domain)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de vehículo.",
                "GetVehicleTypesDTOMapper.toDTO: domain is null"
            );
        }
        return new GetVehicleTypeDTO(domain.getId(), domain.getName());
    }

    public static List<GetVehicleTypeDTO> toDTOList(List<GetVehicleTypeDomain> domains) {
        if (ObjectHelper.isNull(domains)) {
            throw UcoParkingException.create(
                "No se puede procesar la lista de tipos de vehículo.",
                "GetVehicleTypesDTOMapper.toDTOList: domains is null"
            );
        }
        return domains.stream()
            .map(GetVehicleTypeDTOMapper::toDTO)
            .toList();
    }
}
