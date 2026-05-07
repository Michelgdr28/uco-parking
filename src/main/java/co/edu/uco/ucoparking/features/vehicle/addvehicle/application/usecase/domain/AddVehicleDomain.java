package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.usecase.domain;
import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.validation.rule.string.MinLengthStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.MaxLengthStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.NotBlankStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.NotNullStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.RegexStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.uuid.NotNullUUIDRule;
import co.edu.uco.ucoparking.crosscutting.validation.specification.Specification;

public class AddVehicleDomain {

    private static final Specification<String> PLATE_SPEC = buildPlateSpec();
    private static final Specification<UUID> UUID_SPEC = buildUUIDSpec();

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

    private static Specification<String> buildPlateSpec() {

        Specification<String> spec = new Specification<>();

        spec.addRule(new NotNullStringRule(
                "La placa es obligatoria.",
                "AddVehicleDomain.plate: null"));

        spec.addRule(new NotBlankStringRule(
                "La placa no puede estar vacía.",
                "AddVehicleDomain.plate: blank"));

        spec.addRule(new MaxLengthStringRule(7,
                "La placa no puede superar 7 caracteres.",
                "AddVehicleDomain.plate: length > 7"));
        
        spec.addRule(new MinLengthStringRule(6,
				"La placa debe tener al menos 6 caracteres.",
				"AddVehicleDomain.plate: length < 6"));

        spec.addRule(new RegexStringRule(
                "^[A-Z]{3}-?[0-9]{3}$",
                "Formato de placa inválido. Use ABC123 o ABC-123.",
                "AddVehicleDomain.plate: invalid format"));

        return spec;
    }

    private static Specification<UUID> buildUUIDSpec() {

        Specification<UUID> spec = new Specification<>();

        spec.addRule(new NotNullUUIDRule(
                "El campo UUID es obligatorio.",
                "AddVehicleDomain: uuid is null"));

        return spec;
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

        String cleanPlate = (plate == null) ? null : plate.trim().toUpperCase();
        PLATE_SPEC.validate(cleanPlate);

        this.plate = cleanPlate;
    }

    private void setVehicleType(UUID vehicleType) {
        UUID_SPEC.validate(vehicleType);
        this.vehicleType = vehicleType;
    }

    private void setOwner(UUID owner) {
        UUID_SPEC.validate(owner);
        this.owner = owner;
    }
}
