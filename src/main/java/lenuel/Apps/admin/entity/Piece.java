package lenuel.Apps.admin.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piece extends AuditTable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ;

	private UUID trakingId;
	
	private String piece;
	
	public Piece () {}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}
	
	public UUID getTrakingId() {
		return trakingId;
	}

	public void setTrakingId(UUID trakingId) {
		this.trakingId = trakingId;
	}
}
