package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.IdTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.IdTypeJPAEntity;

public final class IdTypeEntityMapper {

    private IdTypeEntityMapper() {
    }

    public static IdTypeJPAEntity toJPA(IdTypeEntity entity) {
        if (entity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de identificación.",
                "IdTypeEntityMapper.toJPA: entity is null"
            );
        }
        return new IdTypeJPAEntity(
            entity.getId(),
            entity.getName()
        );
    }

    public static IdTypeEntity toEntity(IdTypeJPAEntity jpaEntity) {
        if (jpaEntity == null) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de identificación.",
                "IdTypeEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return new IdTypeEntity(
            jpaEntity.getId(),
            jpaEntity.getName()
        );
    }
}
