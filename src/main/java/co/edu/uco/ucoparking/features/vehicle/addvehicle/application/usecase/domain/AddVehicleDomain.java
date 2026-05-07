package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.usecase.domain;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;
import co.edu.uco.ucoparking.crosscutting.helper.UUIDHelper;

public final class AddVehicleDomain {

    private static final String PLATE_PATTERN = "^[A-Z]{3}-?[0-9]{3}$";

    private UUID   id;
    private String plate;
    private UUID   vehicleType;
    private UUID   customer;

    public AddVehicleDomain(String plate, UUID vehicleType, UUID customer) {
        super();
        generateId();
        setPlate(plate);
        setVehicleType(vehicleType);
        setCustomer(customer);
    }

    private void generateId() {
        this.id = UUID.randomUUID();
    }

    public void regenerateId() {
        generateId();
    }

    private void setPlate(String plate) {
        String cleaned = TextHelper.trimAndUpperCase(plate);

        if (TextHelper.isNull(cleaned)) {
            throw UcoParkingException.create(
                "La placa es obligatoria.",
                "AddVehicleDomain.plate: null");
        }
        if (TextHelper.isBlank(cleaned)) {
            throw UcoParkingException.create(
                "La placa no puede estar vacía.",
                "AddVehicleDomain.plate: blank");
        }
        if (TextHelper.isBelowMinLength(cleaned, 6)) {
            throw UcoParkingException.create(
                "La placa debe tener al menos 6 caracteres.",
                "AddVehicleDomain.plate: length < 6");
        }
        if (TextHelper.exceedsMaxLength(cleaned, 7)) {
            throw UcoParkingException.create(
                "La placa no puede superar 7 caracteres.",
                "AddVehicleDomain.plate: length > 7");
        }
        if (TextHelper.doesNotMatchPattern(cleaned, PLATE_PATTERN)) {
            throw UcoParkingException.create(
                "Formato de placa inválido. Use ABC123 o ABC-123.",
                "AddVehicleDomain.plate: invalid format");
        }
        this.plate = cleaned;
    }

    private void setVehicleType(UUID vehicleType) {
        if (UUIDHelper.isNull(vehicleType)) {
            throw UcoParkingException.create(
                "El tipo de vehículo es obligatorio.",
                "AddVehicleDomain.vehicleType: null");
        }
        this.vehicleType = vehicleType;
    }

    private void setCustomer(UUID customer) {
        if (UUIDHelper.isNull(customer)) {
            throw UcoParkingException.create(
                "El cliente del vehículo es obligatorio.",
                "AddVehicleDomain.customer: null");
        }
        this.customer = customer;
    }

    public UUID getId(){ 
    	return id;
    }
    public String getPlate(){
    	return plate; 
    }
    public UUID getVehicleType(){ 
    	return vehicleType;
    }
    public UUID getCustomer(){
    	return customer;
    }
}