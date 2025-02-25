package lenuel.Apps.admin.service;

import java.util.List;
import java.util.UUID;

import lenuel.Apps.admin.dto.request.PieceRequest;
import lenuel.Apps.admin.dto.response.PieceResponse;


public interface PieceService {

	
	public PieceResponse createPiece(PieceRequest pieceRequest  );
	
	
	public PieceResponse updatePiece( PieceRequest pieceRequest , UUID trakingId);
	
	public void delete(UUID trakingId);
	
	public List<PieceResponse> listePiece();
	
}
