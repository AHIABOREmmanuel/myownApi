package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lenuel.Apps.admin.dto.request.PieceRequest;
import lenuel.Apps.admin.dto.response.PieceResponse;
import lenuel.Apps.admin.service.PieceService;

@RestController
@RequestMapping("/api/pieces")
@CrossOrigin(origins = "*")
@Tag(name = "Pièces", description = "API pour gérer les pièces saisies")
public class PieceController {

    private final PieceService pieceService;

    public PieceController(PieceService pieceService) {
        this.pieceService = pieceService;
    }

    //  Créer une pièce
    @PostMapping
    @Operation(summary = "Créer une pièce", description = "Ajoute une nouvelle pièce avec les informations fournies.")
    public ResponseEntity<PieceResponse> createPiece(@RequestBody PieceRequest pieceRequest) {
        PieceResponse createdPiece = pieceService.createPiece(pieceRequest);
        return ResponseEntity.ok(createdPiece);
    }

    //  Mettre à jour une pièce
    @PutMapping("/{trackingId}")
    @Operation(summary = "Mettre à jour une pièce", description = "Modifie les informations d'une pièce spécifique.")
    public ResponseEntity<PieceResponse> updatePiece(
            @PathVariable UUID trackingId,
            @RequestBody PieceRequest pieceRequest) {
        PieceResponse updatedPiece = pieceService.updatePiece(pieceRequest, trackingId);
        return ResponseEntity.ok(updatedPiece);
    }

    //  Supprimer une pièce
    @DeleteMapping("/{trackingId}")
    @Operation(summary = "Supprimer une pièce", description = "Supprime une pièce de la base de données.")
    public ResponseEntity<Void> deletePiece(@PathVariable UUID trackingId) {
        pieceService.delete(trackingId);
        return ResponseEntity.noContent().build();
    }

    //  Liste des pièces
    @GetMapping
    @Operation(summary = "Lister toutes les pièces", description = "Retourne la liste complète des pièces saisies.")
    public ResponseEntity<List<PieceResponse>> getAllPieces() {
        List<PieceResponse> pieces = pieceService.listePiece();
        return ResponseEntity.ok(pieces);
    }
}
