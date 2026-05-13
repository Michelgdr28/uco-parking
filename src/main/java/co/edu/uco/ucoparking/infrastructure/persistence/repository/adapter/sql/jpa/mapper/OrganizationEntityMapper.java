package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.OrganizationEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.OrganizationJPAEntity;

@Mapper(componentModel = "spring")
public interface OrganizationEntityMapper {
	
    OrganizationJPAEntity toJPA(OrganizationEntity entity);
    
    OrganizationEntity toEntity(OrganizationJPAEntity jpaEntity);
    
}