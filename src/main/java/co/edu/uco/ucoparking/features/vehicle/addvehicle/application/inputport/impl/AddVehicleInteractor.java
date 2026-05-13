package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.AddVehicleInputPort;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.validator.AddVehicleDTOValidator;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.AddVehicleUseCase;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;

@Service
@Transactional(rollbackFor = Exception.class)
public class AddVehicleInteractor implements AddVehicleInputPort {

    private final AddVehicleUseCase useCase;

    public AddVehicleInteractor(AddVehicleUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public Void execute(AddVehicleDTO data) {
        String cleanedPlate = AddVehicleDTOValidator.cleanAndValidatePlate(data.getPlate());
        AddVehicleDTOValidator.validateVehicleType(data.getVehicleType());
        AddVehicleDTOValidator.validateOwner(data.getOwner());
        return useCase.execute(new AddVehicleDomain(cleanedPlate, data.getVehicleType(), data.getOwner()));
    }
}
