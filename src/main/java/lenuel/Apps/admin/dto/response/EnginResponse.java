package lenuel.Apps.admin.dto.response;

import java.util.UUID;

import lombok.Builder;


public class EnginResponse{	
	
	private String immatriculation;
	private String commissariat;
	private String motif;
	private String vehicule;
    private UUID trakingId;
    
    
    public EnginResponse() {}
    
    public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	
    public String getCommissariat() {
		return commissariat;
	}

	public void setCommissariat(String commissariat) {
		this.commissariat = commissariat;
	}
	
	
	
    public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
	
    public String getVehicule() {
		return vehicule;
	}

	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}
	
	
	
	public UUID getTrakingId() {
		return trakingId;
	}

	public void setTrakingId(UUID trakingId) {
		this.trakingId = trakingId;
	}
	
}
