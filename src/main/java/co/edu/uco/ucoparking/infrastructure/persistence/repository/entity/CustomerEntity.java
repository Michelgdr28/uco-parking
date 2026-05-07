package co.edu.uco.ucoparking.infrastructure.persistence.repository.entity;

import java.util.UUID;

public class CustomerEntity {
	private UUID id;
	private OrganizationEntity organization;
	private IdTypeEntity idType;
	private String idNumber;
	private String name;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public CustomerEntity(UUID id, OrganizationEntity organization, IdTypeEntity idType, String idNumber, String name,
			String lastName, String email, String phoneNumber) {
		super();
		this.id = id;
		this.organization = organization;
		this.idType = idType;
		this.idNumber = idNumber;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public UUID getId() {
		return id;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public IdTypeEntity getIdType() {
		return idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	private void setId(UUID id) {
		this.id = id;
	}

	private void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	private void setIdType(IdTypeEntity idType) {
		this.idType = idType;
	}

	private void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}

