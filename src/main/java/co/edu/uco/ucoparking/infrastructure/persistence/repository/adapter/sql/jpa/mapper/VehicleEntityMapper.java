package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

@Mapper(componentModel = "spring", uses = {
		
    VehicleTypeEntityMapper.class,
    CustomerEntityMapper.class
    }
)
public interface VehicleEntityMapper {
	
    VehicleJPAEntity toJPA(VehicleEntity entity);
    
    VehicleEntity toEntity(VehicleJPAEntity jpaEntity);
}