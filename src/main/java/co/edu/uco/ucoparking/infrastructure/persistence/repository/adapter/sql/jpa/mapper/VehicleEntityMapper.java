package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.modelmapper.ModelMapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

public final class VehicleEntityMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private VehicleEntityMapper() {
    }

    public static VehicleJPAEntity toJPA(VehicleEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del vehículo.",
                "VehicleEntityMapper.toJPA: entity is null"
            );
        }
        return mapper.map(entity, VehicleJPAEntity.class);
    }

    public static VehicleEntity toEntity(VehicleJPAEntity jpaEntity) {
        if (ObjectHelper.isNull(jpaEntity)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del vehículo.",
                "VehicleEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return mapper.map(jpaEntity, VehicleEntity.class);
    }
}