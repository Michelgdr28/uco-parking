package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.modelmapper.ModelMapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.CustomerEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.CustomerJPAEntity;

public final class CustomerEntityMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private CustomerEntityMapper() {
    }

    public static CustomerJPAEntity toJPA(CustomerEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del cliente.",
                "CustomerEntityMapper.toJPA: entity is null"
            );
        }
        return mapper.map(entity, CustomerJPAEntity.class);
    }

    public static CustomerEntity toEntity(CustomerJPAEntity jpaEntity) {
        if (ObjectHelper.isNull(jpaEntity)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del cliente.",
                "CustomerEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return mapper.map(jpaEntity, CustomerEntity.class);
    }
}