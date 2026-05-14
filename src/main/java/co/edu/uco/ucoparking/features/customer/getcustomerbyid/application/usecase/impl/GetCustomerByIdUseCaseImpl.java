package co.edu.uco.ucoparking.features.customer.getcustomerbyid.application.usecase.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.ucoparking.features.customer.getcustomerbyid.application.usecase.GetCustomerByIdUseCase;
import co.edu.uco.ucoparking.features.customer.getcustomerbyid.application.usecase.rules.CustomerNotFoundException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.CustomerRepository;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;

@Service
public class GetCustomerByIdUseCaseImpl implements GetCustomerByIdUseCase {

    private final CustomerRepository customerRepository;

    public GetCustomerByIdUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerEntity execute(UUID id) {
        CustomerEntity customer = customerRepository.findById(id);
        if (customer == null) {
            throw CustomerNotFoundException.create(id);
        }
        return customer;
    }
}
