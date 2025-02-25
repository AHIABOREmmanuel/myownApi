package lenuel.Apps.admin.services.impls;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lenuel.Apps.admin.dto.request.MotifRequest;
import lenuel.Apps.admin.dto.response.MotifResponse;
import lenuel.Apps.admin.entity.Motif;
import lenuel.Apps.admin.mappers.MotifMapper;
import lenuel.Apps.admin.repository.MotifRepository;
import lenuel.Apps.admin.service.MotifService;


@Service
public class MotifServiceImplement implements MotifService {

    private final MotifRepository motifRepository;
    private final MotifMapper motifMapper;

    // Injection des dépendances
    public MotifServiceImplement(MotifRepository motifRepository, MotifMapper motifMapper) {
        this.motifRepository = motifRepository;
        this.motifMapper = motifMapper;
    }

    @Override
    public MotifResponse createMotif(MotifRequest motifRequest) {
    	Motif motifEntity = motifMapper.toEntity(motifRequest);
        
        // Sauvegarder l'entité Client dans la base de données
    	Motif savedMotif = motifRepository.save(motifEntity);
        
        // Convertir l'entité Client sauvegardée en ClientResponse et retourner
        return motifMapper.toResponse(savedMotif);
    }

    @Override
    public MotifResponse updateMotif(MotifRequest motifRequest, UUID trakingId) {
        // Trouver le client existant par trackingId
    	Motif existingMotif = motifRepository.findByTrakingId(trakingId)
                .orElseThrow(() -> new RuntimeException("Le motif avec cet identifiant n'existe pas"));

        // Mettre à jour les informations du client avec les données du ClientRequest
    	existingMotif.setMotif(motifRequest.getMotif());
        

        // Sauvegarder les modifications
    	Motif updatedMotif= motifRepository.save(existingMotif);
        
        // Retourner la réponse mise à jour
        return motifMapper.toResponse(updatedMotif);
    }

    @Override
    public void delete(UUID idMotif) {
        // Trouver le client à supprimer
    	Motif motifToDelete = motifRepository.findByTrakingId(idMotif)
                .orElseThrow(() -> new RuntimeException("La piece avec cet identifiant n'existe pas"));
        
        // Supprimer le client
    	motifRepository.delete(motifToDelete);
    }

    @Override
    public List<MotifResponse> listeMotif() {
        
        return motifRepository.findAllMotifsOrderedByMotif()
                .stream()
                .map(motifMapper::toResponse)
                .collect(Collectors.toList());
    }
}
