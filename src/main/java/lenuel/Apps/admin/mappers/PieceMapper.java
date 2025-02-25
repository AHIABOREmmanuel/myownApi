package lenuel.Apps.admin.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lenuel.Apps.admin.dto.request.PieceRequest;
import lenuel.Apps.admin.dto.response.PieceResponse;
import lenuel.Apps.admin.entity.Piece;

@Component 
public class PieceMapper {
	public Piece toEntity(PieceRequest dto){
		Piece p= new Piece();
        p.setPiece(dto.getPiece());
        p.setTrakingId(UUID.randomUUID());
        return p;
    }
    
    public PieceResponse toResponse(Piece r) {
    	PieceResponse response = new PieceResponse();
    	response.setPiece(r.getPiece());
    	response.setPieceResponseTrakingId(r.getTrakingId());
		return response;
    	
    }
}