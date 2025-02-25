package lenuel.Apps.admin.services.impls;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lenuel.Apps.admin.dto.request.PieceRequest;
import lenuel.Apps.admin.dto.response.PieceResponse;
import lenuel.Apps.admin.entity.Piece;
import lenuel.Apps.admin.mappers.PieceMapper;
import lenuel.Apps.admin.repository.PieceRepository;
import lenuel.Apps.admin.service.PieceService;


@Service
public class PieceServiceImplement implements PieceService {

    private final PieceRepository pieceRepository;
    private final PieceMapper pieceMapper;

    // Injection des dépendances
    public PieceServiceImplement(PieceRepository pieceRepository, PieceMapper pieceMapper) {
        this.pieceRepository = pieceRepository;
        this.pieceMapper = pieceMapper;
    }

    @Override
    public PieceResponse createPiece(PieceRequest pieceRequest) {
    	Piece pieceEntity = pieceMapper.toEntity(pieceRequest);
        
        // Sauvegarder l'entité Client dans la base de données
    	Piece savedPiece = pieceRepository.save(pieceEntity);
        
        // Convertir l'entité Client sauvegardée en ClientResponse et retourner
        return pieceMapper.toResponse(savedPiece);
    }

    @Override
    public PieceResponse updatePiece(PieceRequest pieceRequest, UUID trakingId) {
        // Trouver le client existant par trackingId
    	Piece existingPiece = pieceRepository.findByTrakingId(trakingId)
                .orElseThrow(() -> new RuntimeException("La piece avec cet identifiant n'existe pas"));

        // Mettre à jour les informations du client avec les données du ClientRequest
    	existingPiece.setPiece(pieceRequest.getPiece());
        

        // Sauvegarder les modifications
    	Piece updatedPiece= pieceRepository.save(existingPiece);
        
        // Retourner la réponse mise à jour
        return pieceMapper.toResponse(updatedPiece);
    }

    @Override
    public void delete(UUID idPiece) {
        // Trouver le client à supprimer
    	Piece pieceToDelete = pieceRepository.findByTrakingId(idPiece)
                .orElseThrow(() -> new RuntimeException("La piece avec cet identifiant n'existe pas"));
        
        // Supprimer le client
    	pieceRepository.delete(pieceToDelete);
    }

    @Override
    public List<PieceResponse> listePiece() {
        // Récupérer la liste de tous les clients ordonnée par nom et mapper vers ClientResponse
        return pieceRepository.findAllPiecesOrdonnerParPiece()
                .stream()
                .map(pieceMapper::toResponse)
                .collect(Collectors.toList());
    }
}
