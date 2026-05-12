package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase;

import java.util.List;

import co.edu.uco.ucoparking.application.usecase.UseCase;
import co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain.GetVehicleTypeDomain;

public interface GetVehicleTypeUseCase extends UseCase<Void, List<GetVehicleTypeDomain>> {
}