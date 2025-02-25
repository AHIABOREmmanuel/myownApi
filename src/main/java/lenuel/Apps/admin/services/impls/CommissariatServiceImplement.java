package lenuel.Apps.admin.services.impls;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;
import lenuel.Apps.admin.entity.Commissariat;
import lenuel.Apps.admin.mappers.CommissariatMapper;
import lenuel.Apps.admin.repository.CommissariatRepository;
import lenuel.Apps.admin.service.CommissariatService;



@Service
@Transactional
public class CommissariatServiceImplement  implements CommissariatService {

    private final CommissariatRepository commissariatRepository;
    private final CommissariatMapper commissariatMapper;

    // Injection des dépendances
    public CommissariatServiceImplement(CommissariatRepository commissariatRepository, CommissariatMapper commissariatMapper) {
        this.commissariatRepository = commissariatRepository;
        this.commissariatMapper = commissariatMapper;
    }

    @Override
    public CommissariatResponse createCommissariat(CommissariatRequest commissariatRequest) {
    	Commissariat CommissariatEntity = commissariatMapper.toEntity(commissariatRequest);
        
        // Sauvegarder l'entité Client dans la base de données
    	Commissariat savedCommissariat = commissariatRepository.save(CommissariatEntity);
        
        // Convertir l'entité Client sauvegardée en ClientResponse et retourner
        return commissariatMapper.toResponse(savedCommissariat);
    }

    @Override
    public CommissariatResponse updateCommissariat(CommissariatRequest commissariatRequest, UUID trakingId) {
        // Trouver le client existant par trackingId
    	Commissariat existingCommissariat = commissariatRepository.findByTrakingId(trakingId)
                .orElseThrow(() -> new RuntimeException("Le client avec cet identifiant n'existe pas"));

        // Mettre à jour les informations du client avec les données du ClientRequest
    	existingCommissariat.setArrondissement  ( commissariatRequest.getArrondissement());
    	existingCommissariat.setAdresse ( commissariatRequest.getAdresse());
    	existingCommissariat.setTel(commissariatRequest.getTel());

        // Sauvegarder les modifications
    	Commissariat updatedCommissariat =commissariatRepository.save ( existingCommissariat);
        
        // Retourner la réponse mise à jour
        return commissariatMapper.toResponse(updatedCommissariat);
    }

    @Override
    public void delete(UUID idCommissariat) {
        // Trouver le client à supprimer
    	Commissariat commissariatToDelete =commissariatRepository.findByTrakingId(idCommissariat)
                .orElseThrow(() -> new RuntimeException("Le Commissariat avec cet identifiant n'existe pas"));
        
        // Supprimer le client
    	commissariatRepository.delete(commissariatToDelete);
    }

    @Override
    public List<CommissariatResponse> listeCommissariat() {
        // Récupérer la liste de tous les clients ordonnée par nom et mapper vers ClientResponse
        return commissariatRepository.findAllCommissariatsOrderedByArrondissement()
                .stream()
                .map(commissariatMapper::toResponse)
                .collect(Collectors.toList());
    }
}


