package co.edu.uco.ucoparking.infrastructure.persistence.repository.adapter.sql.jpa.mapper;

import org.modelmapper.ModelMapper;

import co.edu.uco.ucoparking.crosscutting.exception.UcoParkingException;
import co.edu.uco.ucoparking.crosscutting.helper.ObjectHelper;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.entity.IdTypeEntity;
import co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity.IdTypeJPAEntity;

public final class IdTypeEntityMapper {

    private static final ModelMapper mapper = new ModelMapper();

    private IdTypeEntityMapper() {
    }

    public static IdTypeJPAEntity toJPA(IdTypeEntity entity) {
        if (ObjectHelper.isNull(entity)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de identificación.",
                "IdTypeEntityMapper.toJPA: entity is null"
            );
        }
        return mapper.map(entity, IdTypeJPAEntity.class);
    }

    public static IdTypeEntity toEntity(IdTypeJPAEntity jpaEntity) {
        if (ObjectHelper.isNull(jpaEntity)) {
            throw UcoParkingException.create(
                "No se pueden procesar los datos del tipo de identificación.",
                "IdTypeEntityMapper.toEntity: jpaEntity is null"
            );
        }
        return mapper.map(jpaEntity, IdTypeEntity.class);
    }
}
