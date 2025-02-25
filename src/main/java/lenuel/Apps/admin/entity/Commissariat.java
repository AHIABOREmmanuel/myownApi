package lenuel.Apps.admin.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Commissariat extends AuditTable implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;

	private UUID trakingId;
	
	private String arrondissement;
	
	private String adresse;
	
	private String tel;
	
	public Commissariat() {}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	

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
	
	public UUID getTrakingId() {
		return trakingId;
	}

	public void setTrakingId(UUID trakingId) {
		this.trakingId = trakingId;
	}
}
