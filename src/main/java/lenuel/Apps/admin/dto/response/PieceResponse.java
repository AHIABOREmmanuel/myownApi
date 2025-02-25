package lenuel.Apps.admin.dto.response;

import java.util.UUID;

public class PieceResponse {
	private UUID pieceResponseTrakingId;
    private String piece;

	
	public PieceResponse () {}
	
	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}
	

	public UUID getPieceResponseTrakingId() {
		return pieceResponseTrakingId;
	}

	public void setPieceResponseTrakingId(UUID pieceResponseTrakingId) {
		this.pieceResponseTrakingId = pieceResponseTrakingId;
	}
}
