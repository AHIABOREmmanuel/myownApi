package lenuel.Apps.admin.dto.request;

import java.util.UUID;

public class EnginRequest {
	private String immatriculation;
	private UUID commissariatId;
	private UUID motifId;
	private UUID vehiculeId;
	
	public EnginRequest () {}

	
	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	
	public UUID getCommissariatId() {
		return commissariatId;
	}



	public void setCommissariatId(UUID commissariatId) {
		this.commissariatId = commissariatId;
	}

	public UUID getMotifId() {
		return motifId;
	}



	public void setMotifId(UUID motifId) {
		this.motifId = motifId;
	}
	
	
	public UUID getVehiculeId() {
		return vehiculeId;
	}



	public void setVehiculeId(UUID vehiculeId) {
		this.vehiculeId = vehiculeId;
	}
}
