package lenuel.Apps.admin.dto.response;

import java.util.UUID;

public class CommissariatResponse {
	
	private UUID commissariatResponseTrakingId;
    private String arrondissement;
    private String adresse;
    private String tel;
	
	public CommissariatResponse () {}
	
	public String getArrondissement() {
		return arrondissement;
	}

	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public UUID getCommissariatResponseTrakingId() {
		return commissariatResponseTrakingId;
	}

	public void setCommissariatResponseTrakingId(UUID commissariatResponseTrakingId) {
		this.commissariatResponseTrakingId = commissariatResponseTrakingId;
	}
}
