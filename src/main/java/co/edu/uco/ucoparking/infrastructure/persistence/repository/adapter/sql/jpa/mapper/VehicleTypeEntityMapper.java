package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleTypeJPAEntity;

@Mapper(componentModel = "spring")
public interface VehicleTypeEntityMapper {
	
    VehicleTypeJPAEntity toJPA(VehicleTypeEntity entity);
    
    VehicleTypeEntity toEntity(VehicleTypeJPAEntity jpaEntity);
    
    List<VehicleTypeEntity> toEntityList(List<VehicleTypeJPAEntity> jpaEntities);
}