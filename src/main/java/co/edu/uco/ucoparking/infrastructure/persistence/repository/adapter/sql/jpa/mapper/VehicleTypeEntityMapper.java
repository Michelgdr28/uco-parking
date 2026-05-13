package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleTypeJPAEntity;

@Mapper(componentModel = "spring")
public interface VehicleTypeEntityMapper {
	
    VehicleTypeJPAEntity toJPA(VehicleTypeEntity entity);
    
    VehicleTypeEntity toEntity(VehicleTypeJPAEntity jpaEntity);
    
}