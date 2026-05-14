package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.customer.getcustomerbyid.application.usecase.GetCustomerByIdUseCase;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.AddVehicleUseCase;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.mapper.AddVehicleDomainMapper;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules.VehicleAlreadyExistsException;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.rules.VehicleTypeAlreadyAssignedException;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletypebyid.application.usecase.GetVehicleTypeByIdUseCase;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

@Service
public class AddVehicleUseCaseImpl implements AddVehicleUseCase {

    private final GetCustomerByIdUseCase    getCustomerByIdUseCase;
    private final GetVehicleTypeByIdUseCase getVehicleTypeByIdUseCase;
    private final VehicleRepository         vehicleRepository;
    private final AddVehicleDomainMapper    mapper;

    public AddVehicleUseCaseImpl(GetCustomerByIdUseCase getCustomerByIdUseCase,
                                 GetVehicleTypeByIdUseCase getVehicleTypeByIdUseCase,
                                 VehicleRepository vehicleRepository,
                                 AddVehicleDomainMapper mapper) {
        this.getCustomerByIdUseCase    = getCustomerByIdUseCase;
        this.getVehicleTypeByIdUseCase = getVehicleTypeByIdUseCase;
        this.vehicleRepository         = vehicleRepository;
        this.mapper                    = mapper;
    }

    @Override
    public Void execute(AddVehicleDomain data) {
        CustomerEntity    owner       = getCustomerByIdUseCase.execute(data.getOwner());
        VehicleTypeEntity vehicleType = getVehicleTypeByIdUseCase.execute(data.getVehicleType());

        VehicleEntity plateFilter = new VehicleEntity(null, data.getPlate(), null, null);
        if (!vehicleRepository.findByFilter(plateFilter).isEmpty()) {
            throw VehicleAlreadyExistsException.create(data.getPlate());
        }

        VehicleEntity ownerTypeFilter = new VehicleEntity(null, null, vehicleType, owner);
        if (!vehicleRepository.findByFilter(ownerTypeFilter).isEmpty()) {
            throw VehicleTypeAlreadyAssignedException.create(data.getOwner(), data.getVehicleType());
        }

        vehicleRepository.create(mapper.toEntity(data, vehicleType, owner));

        return null;
    }
}
