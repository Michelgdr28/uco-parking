package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.VehicleEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.VehicleJPAEntity;

@Mapper(componentModel = "spring", uses = {
		
    VehicleTypeEntityMapper.class,
    CustomerEntityMapper.class
    }
)
public interface VehicleEntityMapper {
	
	@Mapping(source = "owner", target = "customer")
    VehicleJPAEntity toJPA(VehicleEntity entity);

    @Mapping(source = "customer", target = "owner")
    VehicleEntity toEntity(VehicleJPAEntity jpaEntity);
    
    List<VehicleEntity> toEntityList(List<VehicleJPAEntity> jpaEntities);
}