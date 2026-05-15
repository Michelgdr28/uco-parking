package co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.validator;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;
import co.edu.uco.ucoparking.crosscutting.helper.UUIDHelper;
import co.edu.uco.ucoparking.features.vehicle.addvehicle.application.inputport.dto.AddVehicleDTO;

public final class AddVehicleDTOValidator {

    private static final String PLATE_PATTERN = "^[A-Z]{3}-?[0-9]{3}$";

    private AddVehicleDTOValidator() {
    }

    public static void cleanAndValidate(AddVehicleDTO dto) {
        String cleanedPlate = TextHelper.cleanAndUpperCase(dto.getPlate());

        if (TextHelper.isBlank(cleanedPlate)) {
            throw UcoParkingException.create(
                "La placa del vehículo es obligatoria.",
                "AddVehicleDTO.plate: blank or null"
            );
        }
        if (TextHelper.isBelowMinLength(cleanedPlate, 6)) {
            throw UcoParkingException.create(
                "La placa debe tener mínimo 6 caracteres.",
                "AddVehicleDTO.plate: length < 6"
            );
        }
        if (TextHelper.exceedsMaxLength(cleanedPlate, 7)) {
            throw UcoParkingException.create(
                "La placa no puede superar 7 caracteres.",
                "AddVehicleDTO.plate: length > 7"
            );
        }
        if (TextHelper.doesNotMatchPattern(cleanedPlate, PLATE_PATTERN)) {
            throw UcoParkingException.create(
                "El formato de placa no es válido. Use ABC123 o ABC-123.",
                "AddVehicleDTO.plate: does not match " + PLATE_PATTERN
            );
        }
        if (UUIDHelper.isNull(dto.getVehicleType())) {
            throw UcoParkingException.create(
                "El tipo de vehículo es obligatorio.",
                "AddVehicleDTO.vehicleType: null"
            );
        }
        if (UUIDHelper.isNull(dto.getOwner())) {
            throw UcoParkingException.create(
                "El propietario del vehículo es obligatorio.",
                "AddVehicleDTO.owner: null"
            );
        }

        dto.setPlate(cleanedPlate);
    }
}