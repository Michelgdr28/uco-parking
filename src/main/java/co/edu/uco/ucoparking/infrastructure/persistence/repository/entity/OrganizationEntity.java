package co.edu.uco.ucoparking.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.ucoparking.crosscutting.helper.TextHelper;

public class OrganizationEntity {
	private UUID id;
	private String name;
	
	public OrganizationEntity(UUID id, String name) {
		super();
		setId(id);
		setName(name);
	}
	public UUID getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	private void setId(UUID id) {
		this.id = id;
	}
	private void setName(String name) {
		this.name = TextHelper.clean(name);
	}

}
