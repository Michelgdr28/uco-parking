package co.edu.uco.ucoparking.features.vehicule.addvehicle.application.inputport.dto;

import java.util.UUID;

public class AddVehicleDTO {

		private String plate;
		private UUID vehicleType;
		private UUID owner;
		
		public AddVehicleDTO(String plate, UUID vehicleType, UUID owner) {
			super();
			setPlate(plate);
			setVehicleType(vehicleType);
			setOwner(owner);
		
			
		}
		private String getPlate() {
			return plate;
		}
		private void setPlate(String plate) {
			this.plate = plate;
		}
		private UUID getVehicleType() {
			return vehicleType;
		}
		private void setVehicleType(UUID vehicleType) {
			this.vehicleType = vehicleType;
		}
		private UUID getOwner() {
			return owner;
		}
		private void setOwner(UUID owner) {
			this.owner = owner;
		}
		
		
	}
