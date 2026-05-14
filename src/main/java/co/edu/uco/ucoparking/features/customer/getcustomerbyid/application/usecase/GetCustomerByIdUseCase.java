package co.edu.uco.ucoparking.features.customer.getcustomerbyid.application.usecase;

import java.util.UUID;

import co.edu.uco.ucoparking.application.usecase.UseCase;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;

public interface GetCustomerByIdUseCase extends UseCase<UUID, CustomerEntity> {
}
