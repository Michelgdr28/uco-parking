package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

public final class VehicleEntityMapper {

    private VehicleEntityMapper() {
    }

    public static VehicleJPAEntity toJPA(VehicleEntity entity) {
        if (entity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del vehículo.",
                "VehicleEntityMapper.toJPA: entity is null"
            );
        }
        return new VehicleJPAEntity(
            entity.getId(),
            entity.getPlate(),
            VehicleTypeEntityMapper.toJPA(entity.getVehicleType()),  
            CustomerEntityMapper.toJPA(entity.getOwner())            
        );
    }

    public static VehicleEntity toEntity(VehicleJPAEntity jpaEntity) {
        if (jpaEntity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del vehículo.",
                "VehicleEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return new VehicleEntity(
            jpaEntity.getId(),
            jpaEntity.getPlate(),
            VehicleTypeEntityMapper.toEntity(jpaEntity.getVehicleType()),  
            CustomerEntityMapper.toEntity(jpaEntity.getCustomer())         
        );
    }
}
