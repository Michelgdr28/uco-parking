package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.impl;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;

@Mapper(componentModel = "spring")
public interface AddVehicleDTOMapper {

    @Mapping(source = "plate", target = "plate")
    @Mapping(source = "vehicleType", target = "vehicleType")
    @Mapping(source = "owner", target = "owner")
    AddVehicleDomain toDomain(AddVehicleDTO dto);
}
