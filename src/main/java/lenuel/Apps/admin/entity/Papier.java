package lenuel.Apps.admin.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Papier extends AuditTable implements Serializable{
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
	@JoinColumn(name="pieceId")
	private Piece piece;
	
	public Papier () {}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	
	
	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String Immatriculation) {
		Immatriculation = immatriculation;
	}
	
	
	public Commissariat getCommissariat() {
		return commissariat;
	}

	public void setCommissaria(Commissariat commissariat) {
		this.commissariat = commissariat;
	}
	
	
	public Motif getMotif() {
		return motif;
	}

	public void Motif(Motif motif) {
		this.motif = motif;
	}
	
	
	
	public Piece getPiece() {
		return piece;
	}

	public void Vehicule(Piece piece) {
		this.piece = piece;
	}
	
	
	
	public UUID getTrakingId() {
		return trakingId;
	}

	public void setTrakingId(UUID trakingId) {
		this.trakingId = trakingId;
	}
}
