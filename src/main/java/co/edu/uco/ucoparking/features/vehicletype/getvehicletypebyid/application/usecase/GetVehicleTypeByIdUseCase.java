package co.edu.uco.ucoparking.features.vehicletype.getvehicletypebyid.application.usecase;

import java.util.UUID;

import co.edu.uco.ucoparking.application.usecase.UseCase;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;

public interface GetVehicleTypeByIdUseCase extends UseCase<UUID, VehicleTypeEntity> {
}
