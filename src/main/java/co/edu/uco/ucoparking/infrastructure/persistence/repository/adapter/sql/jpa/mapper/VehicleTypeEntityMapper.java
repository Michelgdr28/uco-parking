package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.modelmapper.ModelMapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleTypeJPAEntity;

public final class VehicleTypeEntityMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private VehicleTypeEntityMapper() {
    }

    public static VehicleTypeJPAEntity toJPA(VehicleTypeEntity entity) {
        if (entity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de vehículo.",
                "VehicleTypeEntityMapper.toJPA: entity is null"
            );
        }
        return mapper.map(entity, VehicleTypeJPAEntity.class);
    }

    public static VehicleTypeEntity toEntity(VehicleTypeJPAEntity jpaEntity) {
        if (jpaEntity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de vehículo.",
                "VehicleTypeEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return mapper.map(jpaEntity, VehicleTypeEntity.class);
    }
}