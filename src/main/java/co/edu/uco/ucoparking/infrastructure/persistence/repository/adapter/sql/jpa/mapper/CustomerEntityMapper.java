package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.CustomerJPAEntity;

public final class CustomerEntityMapper {

    private CustomerEntityMapper() {
    }

    public static CustomerJPAEntity toJPA(CustomerEntity entity) {
        if (entity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del cliente.",
                "CustomerEntityMapper.toJPA: entity is null"
            );
        }
        return new CustomerJPAEntity(
            entity.getId(),
            OrganizationEntityMapper.toJPA(entity.getOrganization()),  
            IdTypeEntityMapper.toJPA(entity.getIdType()),              
            VehicleTypeEntityMapper.toJPA(entity.getVehicleType()),    
            entity.getIdNumber(),
            entity.getName(),
            entity.getLastName(),
            entity.getEmail(),
            entity.getPhoneNumber()
        );
    }

    public static CustomerEntity toEntity(CustomerJPAEntity jpaEntity) {
        if (jpaEntity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del cliente.",
                "CustomerEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return new CustomerEntity(
            jpaEntity.getId(),
            OrganizationEntityMapper.toEntity(jpaEntity.getOrganization()),  
            VehicleTypeEntityMapper.toEntity(jpaEntity.getVehicleType()),    
            IdTypeEntityMapper.toEntity(jpaEntity.getIdType()),              
            jpaEntity.getIdNumber(),
            jpaEntity.getName(),
            jpaEntity.getLastName(),
            jpaEntity.getEmail(),
            jpaEntity.getPhoneNumber()
        );
    }
}