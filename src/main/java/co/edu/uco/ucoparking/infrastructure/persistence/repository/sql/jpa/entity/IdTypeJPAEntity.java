package co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "id_type")
public class IdTypeJPAEntity {

	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "name")
	private String name;
	
	protected IdTypeJPAEntity() {
		
	}
	
	public IdTypeJPAEntity(UUID id, String name) {
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

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
