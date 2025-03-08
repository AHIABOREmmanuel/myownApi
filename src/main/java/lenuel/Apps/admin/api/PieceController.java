package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lenuel.Apps.admin.dto.request.MotifRequest;
import lenuel.Apps.admin.dto.request.PieceRequest;
import lenuel.Apps.admin.dto.response.MotifResponse;
import lenuel.Apps.admin.dto.response.PieceResponse;
import lenuel.Apps.admin.service.MotifService;
import lenuel.Apps.admin.service.PieceService;

@RestController
@RequestMapping("/api/pieces")
@CrossOrigin(origins = "*")
public class PieceController {

	 private final PieceService pieceService;

	    
	    public PieceController(PieceService pieceService) {
	        this.pieceService = pieceService;
	    }

	    // Créer une piece
	    @PostMapping
	    public ResponseEntity<PieceResponse> createPiece(@RequestBody PieceRequest pieceRequest) {
	    	PieceResponse createPiece = pieceService.createPiece(pieceRequest);
	        return ResponseEntity.ok(createPiece);
	    }

	    // Mettre à jour une piece
	    @PutMapping("/{trackingId}")
	    public ResponseEntity<PieceResponse> updatePiece(
	            @PathVariable UUID trackingId,
	            @RequestBody PieceRequest pieceRequest
	    ) {
	    	PieceResponse updatePiece = pieceService.updatePiece(pieceRequest, trackingId);
	        return ResponseEntity.ok(updatePiece);
	    }

	    // Supprimer une piece
	    @DeleteMapping("/{trackingId}")
	    public ResponseEntity<Void> deletePiece(@PathVariable UUID idPiece) {
	    	pieceService.delete(idPiece);
	        return ResponseEntity.noContent().build(); 
	    }

	    // Liste des pieces
	    @GetMapping
	    public ResponseEntity<List<PieceResponse>> getAllPieces() {
	        List<PieceResponse> pieces =pieceService.listePiece();
	        return ResponseEntity.ok(pieces);
	    }
	
}
