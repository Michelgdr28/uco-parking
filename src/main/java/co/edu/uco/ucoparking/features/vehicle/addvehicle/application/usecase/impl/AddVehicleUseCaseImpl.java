package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain.AddVehicleDomain;
import co.edu.uco.ucoparking.features.vehicule.addvehicle.application.usecase.AddVehicleUseCase;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.CustomerRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.VehicleRepository;

@Service
public class AddVehicleUseCaseImpl implements AddVehicleUseCase {
	
	private CustomerRepository customerRepository;
	private VehicleRepository vehicleRepository;
	
	public AddVehicleUseCaseImpl(CustomerRepository customerRepository, VehicleRepository vehicleRepository) {
		this.customerRepository = customerRepository;
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public Void execute(AddVehicleDomain data) {
		// TODO Auto-generated method stub
		return null;
	}

}
