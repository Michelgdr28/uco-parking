package co.edu.uco.ucoparking.features.vehicletype.getvehicletypebyid.application.usecase.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.vehicletype.getvehicletypebyid.application.usecase.GetVehicleTypeByIdUseCase;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletypebyid.application.usecase.rules.VehicleTypeNotFoundException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleTypeRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

@Service
public class GetVehicleTypeByIdUseCaseImpl implements GetVehicleTypeByIdUseCase {

    private final VehicleTypeRepository vehicleTypeRepository;

    public GetVehicleTypeByIdUseCaseImpl(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public VehicleTypeEntity execute(UUID id) {
        VehicleTypeEntity vehicleType = vehicleTypeRepository.findById(id);
        if (vehicleType == null) {
            throw VehicleTypeNotFoundException.create(id);
        }
        return vehicleType;
    }
}
