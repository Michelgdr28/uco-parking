package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.IdTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.IdTypeJPAEntity;

@Mapper(componentModel = "spring")
public interface IdTypeEntityMapper {
	
    IdTypeJPAEntity toJPA(IdTypeEntity entity);
    
    IdTypeEntity toEntity(IdTypeJPAEntity jpaEntity);
    
}
