package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.impl;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto.GetVehicleTypeDTO;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain.GetVehicleTypeDomain;

@Mapper(componentModel = "spring")
public interface GetVehicleTypeDTOMapper {
	
    GetVehicleTypeDTO toDTO(GetVehicleTypeDomain domain);
    
    List<GetVehicleTypeDTO> toDTOList(List<GetVehicleTypeDomain> domains);
}
