package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.mapstruct.Mapper;

import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.CustomerJPAEntity;

@Mapper(componentModel = "spring", uses = {
    OrganizationEntityMapper.class,
    IdTypeEntityMapper.class,
    }
)

public interface CustomerEntityMapper {
    CustomerJPAEntity toJPA(CustomerEntity entity);
    CustomerEntity toEntity(CustomerJPAEntity jpaEntity);
    
}