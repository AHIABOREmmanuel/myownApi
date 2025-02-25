package lenuel.Apps.admin.entity;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Engin extends AuditTable implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;

	private UUID trakingId;

	
	@Column(name="immatriculation" , nullable = false)
	private String immatriculation;
	
	
	@ManyToOne
	@JoinColumn(name="commissariatId")
	private Commissariat commissariat;
	
	
	@ManyToOne
	@JoinColumn(name="motifId")
	private Motif motif;
	
	
	@ManyToOne
	@JoinColumn(name="vehiculeId")
	private Vehicule vehicule;
	
	public Engin () {}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	public Commissariat getCommissariat() {
		return commissariat;
	}

	public void setCommissariat(Commissariat commissariat) {
		this.commissariat = commissariat;
	}
	
	
	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}
	
	
	
	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	
	
	public UUID getTrakingId() {
		return trakingId;
	}

	public void setTrakingId(UUID trakingId) {
		this.trakingId = trakingId;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	
}
