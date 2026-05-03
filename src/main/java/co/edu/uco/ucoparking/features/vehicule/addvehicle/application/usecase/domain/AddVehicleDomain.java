package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.usecase.domain;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.validation.rule.string.MaxLengthStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.NotBlankStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.NotNullStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.uuid.NotNullUUIDRule;
import co.edu.uco.ucoparking.crosscutting.validation.specification.Specification;

public class AddVehicleDomain {

    private static final Specification<String> PLATE_SPEC = new Specification<>(
        new NotNullStringRule(
            "La placa es obligatoria.",
            "AddVehicleDomain.plate: null"),
        new NotBlankStringRule(
            "La placa no puede estar vacía.",
            "AddVehicleDomain.plate: blank"),
        new MaxLengthStringRule(7,
            "La placa no puede superar 7 caracteres.",
            "AddVehicleDomain.plate: length > 7")
    );

    private static final Specification<UUID> NOT_NULL_UUID_SPEC = new Specification<>(
        new NotNullUUIDRule(
            "El campo UUID es obligatorio.",
            "AddVehicleDomain: uuid is null")
    );

    private UUID id;
    private String plate;
    private UUID vehicleType;
    private UUID owner;

    public AddVehicleDomain(String plate, UUID vehicleType, UUID owner) {
        super();
        this.id = UUID.randomUUID();
        setPlate(plate);
        setVehicleType(vehicleType);
        setOwner(owner);
    }

    public UUID getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public UUID getVehicleType() {
        return vehicleType;
    }

    public UUID getOwner() {
        return owner;
    }

    private void setPlate(String plate) {
        PLATE_SPEC.validate(plate);
        this.plate = plate;
    }

    private void setVehicleType(UUID vehicleType) {
        NOT_NULL_UUID_SPEC.validate(vehicleType);
        this.vehicleType = vehicleType;
    }

    private void setOwner(UUID owner) {
        NOT_NULL_UUID_SPEC.validate(owner);
        this.owner = owner;
    }
}
