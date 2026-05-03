package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.inputport.dto.validator;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.validation.cleaner.Cleaner;
import co.edu.uco.ucoparking.crosscutting.validation.cleaner.string.TrimUpperCaseStringCleaner;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.MaxLengthStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.MinLengthStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.NotBlankStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.NotNullStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.string.RegexStringRule;
import co.edu.uco.ucoparking.crosscutting.validation.rule.uuid.NotNullUUIDRule;
import co.edu.uco.ucoparking.crosscutting.validation.specification.Specification;

public final class AddVehicleDTOValidator {

    private static final String PLATE_PATTERN = "^[A-Z]{3}-?[0-9]{3}$";

    private static final Cleaner<String> PLATE_CLEANER = new TrimUpperCaseStringCleaner();

    private static final Specification<String> PLATE_SPEC = new Specification<>(
        new NotNullStringRule(
            "La placa del vehículo es obligatoria.",
            "AddVehicleDTO.plate: null"),
        new NotBlankStringRule(
            "La placa del vehículo no puede estar vacía.",
            "AddVehicleDTO.plate: blank"),
        new MinLengthStringRule(6,
            "La placa debe tener mínimo 6 caracteres.",
            "AddVehicleDTO.plate: length < 6"),
        new MaxLengthStringRule(7,
            "La placa no puede superar 7 caracteres.",
            "AddVehicleDTO.plate: length > 7"),
        new RegexStringRule(PLATE_PATTERN,
            "El formato de placa no es válido. Use ABC123 o ABC-123.",
            "AddVehicleDTO.plate: does not match " + PLATE_PATTERN)
    );

    private static final Specification<UUID> VEHICLE_TYPE_SPEC = new Specification<>(
        new NotNullUUIDRule(
            "El tipo de vehículo es obligatorio.",
            "AddVehicleDTO.vehicleType: null")
    );

    private static final Specification<UUID> OWNER_SPEC = new Specification<>(
        new NotNullUUIDRule(
            "El propietario del vehículo es obligatorio.",
            "AddVehicleDTO.owner: null")
    );

    private AddVehicleDTOValidator() {
    }

    public static String cleanAndValidatePlate(String plate) {
        String cleaned = PLATE_CLEANER.clean(plate);
        PLATE_SPEC.validate(cleaned);
        return cleaned;
    }

    public static void validateVehicleType(UUID vehicleType) {
        VEHICLE_TYPE_SPEC.validate(vehicleType);
    }

    public static void validateOwner(UUID owner) {
        OWNER_SPEC.validate(owner);
    }
}
