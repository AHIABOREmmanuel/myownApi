package lenuel.Apps.admin.dto.request;

public class CommissariatRequest {
	
private String arrondissement;
	
	private String adresse;
	
	private String tel;
	
	public CommissariatRequest () {}


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
}
