package co.edu.uco.ucoparking.infrastructure.persistence.repository.sql.jpa.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class CustomerJPAEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "organization")
	private OrganizationJPAEntity organization;
	
	@ManyToOne
	@JoinColumn(name = "id_type")
	private IdTypeJPAEntity idType;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_type")
	private VehicleTypeJPAEntity vehicleType;
	
	@Column(name = "document_number")
	private String idNumber;
	
	@Column(name = "first_name")
	private String Name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "correo")
	private String email;
	
	@Column(name = "telefono")
	private String  phoneNumber;
	
	protected CustomerJPAEntity() {
		
	}
    
	public CustomerJPAEntity(UUID id, OrganizationJPAEntity organization, IdTypeJPAEntity idType,
			VehicleTypeJPAEntity vehicleType,String idNumber, String name, String lastName, String email, String phoneNumber) {
        super();
        setId(id);
        setOrganization(organization);
        setIdType(idType);
        setVehicleType(vehicleType);
        setIdNumber(idNumber);
        setName(name);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

	public UUID getId() {
		return id;
	}

	public OrganizationJPAEntity getOrganization() {
		return organization;
	}

	public IdTypeJPAEntity getIdType() {
		return idType;
	}

	public VehicleTypeJPAEntity getVehicleType() {
		return vehicleType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getName() {
		return Name;
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

	private void setOrganization(OrganizationJPAEntity organization) {
		this.organization = organization;
	}

	private void setIdType(IdTypeJPAEntity idType) {
		this.idType = idType;
	}

	private void setVehicleType(VehicleTypeJPAEntity vehicleType) {
		this.vehicleType = vehicleType;
	}

	private void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	private void setName(String name) {
		Name = name;
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
