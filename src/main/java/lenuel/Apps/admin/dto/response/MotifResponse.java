package lenuel.Apps.admin.dto.response;

import java.util.UUID;

public class MotifResponse {
	private UUID motifResponseTrakingId;
    private String motif;

	
	public MotifResponse () {}
	
	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	


	public UUID getMotifResponseTrakingId() {
		return motifResponseTrakingId;
	}

	public void setmotifResponseTrakingId(UUID motifResponseTrakingId) {
		this.motifResponseTrakingId = motifResponseTrakingId;
	}
}
