package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.GetVehicleTypeUseCase;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain.GetVehicleTypeDomain;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleTypeRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

@Service
public class GetVehicleTypeUseCaseImpl implements GetVehicleTypeUseCase {

    private final VehicleTypeRepository vehicleTypeRepository;

    public GetVehicleTypeUseCaseImpl(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public List<GetVehicleTypeDomain> execute(Void data) {
        return vehicleTypeRepository.findAll()
            .stream()
            .map(this::toDomain)
            .toList();
    }

    private GetVehicleTypeDomain toDomain(VehicleTypeEntity entity) {
        return new GetVehicleTypeDomain(
            entity.getId(),
            entity.getName()
        );
    }
}
