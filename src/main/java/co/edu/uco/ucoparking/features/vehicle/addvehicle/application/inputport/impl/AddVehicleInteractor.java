package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.AddVehicleInputPort;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.validator.AddVehicleDTOValidator;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.AddVehicleUseCase;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddVehicleInteractor implements AddVehicleInputPort {

    private final AddVehicleUseCase useCase;
    private final AddVehicleDTOMapper mapper;

    public AddVehicleInteractor(AddVehicleUseCase useCase, AddVehicleDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public Void execute(AddVehicleDTO data) {
        AddVehicleDTOValidator.cleanAndValidate(data);
        return useCase.execute(mapper.toDomain(data));
    }
}