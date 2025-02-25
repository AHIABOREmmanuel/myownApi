package lenuel.Apps.admin.dto.response;

import java.util.UUID;

public class VehiculeResponse {

	private UUID vehiculeResponseTrakingId;
    private String modele;

	
	public VehiculeResponse () {}
	
	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	


	public UUID getVehiculeResponseTrakingId() {
		return vehiculeResponseTrakingId;
	}

	public void setVehiculeResponseTrakingId(UUID vehiculeResponseTrakingId) {
		this.vehiculeResponseTrakingId = vehiculeResponseTrakingId;
	}
}
