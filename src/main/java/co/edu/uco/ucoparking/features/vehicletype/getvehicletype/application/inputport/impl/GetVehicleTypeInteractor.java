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
    private final GetVehicleTypeDTOMapper mapper;

    public GetVehicleTypeInteractor(GetVehicleTypeUseCase useCase,
                                    GetVehicleTypeDTOMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @Override
    public List<GetVehicleTypeDTO> execute(Void data) {
        return useCase.execute(null)
            .stream()
            .map(mapper::toDTO)
            .toList();
    }
}