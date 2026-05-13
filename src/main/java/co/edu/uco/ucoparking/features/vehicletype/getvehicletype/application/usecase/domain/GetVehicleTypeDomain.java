package co.edu.uco.ucoparking.features.vehicletype.getvehicletype.application.usecase.domain;

import java.util.UUID;

public final class GetVehicleTypeDomain {

    private UUID id;
    private String name;

    public GetVehicleTypeDomain(UUID id, String name) {
        super();
        setId(id);
        setName(name);
    }

    private void setId(UUID id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
}
