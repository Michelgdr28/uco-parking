package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.GetVehicleTypeInputPort;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.dto.GetVehicleTypeDTO;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.inputport.mapper.GetVehicleTypeDTOMapper;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.GetVehicleTypeUseCase;

@Service
public class GetVehicleTypeInteractor implements GetVehicleTypeInputPort {

    private final GetVehicleTypeUseCase useCase;

    public GetVehicleTypeInteractor(GetVehicleTypeUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public List<GetVehicleTypeDTO> execute(Void data) {
        return GetVehicleTypeDTOMapper.toDTOList(useCase.execute(null));
    }
}