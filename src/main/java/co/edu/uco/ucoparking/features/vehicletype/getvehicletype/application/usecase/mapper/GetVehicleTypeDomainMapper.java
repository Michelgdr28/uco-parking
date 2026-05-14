package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain.GetVehicleTypeDomain;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

@Mapper(componentModel = "spring")
public interface GetVehicleTypeDomainMapper { 
	GetVehicleTypeDomain toDomain(VehicleTypeEntity entity);
}