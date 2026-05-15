package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.GetVehicleTypeUseCase;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain.GetVehicleTypeDomain;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleTypeRepository;

@Service
public class GetVehicleTypeUseCaseImpl implements GetVehicleTypeUseCase {

    private final VehicleTypeRepository vehicleTypeRepository;
    private final GetVehicleTypeDomainMapper mapper;

    public GetVehicleTypeUseCaseImpl(VehicleTypeRepository vehicleTypeRepository,
                                     GetVehicleTypeDomainMapper mapper) {
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GetVehicleTypeDomain> execute(Void data) {
        return vehicleTypeRepository.findAll()
            .stream()
            .map(mapper::toDomain)
            .toList();
    }
}
