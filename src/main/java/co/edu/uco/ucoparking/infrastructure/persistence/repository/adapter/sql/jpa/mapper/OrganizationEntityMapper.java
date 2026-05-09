package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.OrganizationEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.OrganizationJPAEntity;

public final class OrganizationEntityMapper {

    private OrganizationEntityMapper() {
    }

    public static OrganizationJPAEntity toJPA(OrganizationEntity entity) {
        if (entity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos de la organización.",
                "OrganizationEntityMapper.toJPA: entity is null"
            );
        }
        return new OrganizationJPAEntity(
            entity.getId(),
            entity.getName()
        );
    }

    public static OrganizationEntity toEntity(OrganizationJPAEntity jpaEntity) {
        if (jpaEntity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos de la organización.",
                "OrganizationEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return new OrganizationEntity(
            jpaEntity.getId(),
            jpaEntity.getName()
        );
    }
}
