package lenuel.Apps.admin.services.impls;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lenuel.Apps.admin.dto.request.VehiculeRequest;
import lenuel.Apps.admin.dto.response.VehiculeResponse;
import lenuel.Apps.admin.entity.Vehicule;
import lenuel.Apps.admin.mappers.VehiculeMapper;
import lenuel.Apps.admin.repository.VehiculeRepository;
import lenuel.Apps.admin.service.VehiculeService;


@Service
public class VehiculeServiceImplement implements VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    // Injection des dépendances
    public VehiculeServiceImplement(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    @Override
    public VehiculeResponse createVehicule(VehiculeRequest vehiculeRequest) {
    	Vehicule vehiculeEntity = vehiculeMapper.toEntity(vehiculeRequest);
        
        // Sauvegarder l'entité Client dans la base de données
    	Vehicule savedVehicule = vehiculeRepository.save(vehiculeEntity);
        
        // Convertir l'entité Client sauvegardée en ClientResponse et retourner
        return vehiculeMapper.toResponse(savedVehicule);
    }

    @Override
    public VehiculeResponse updateVehicule(VehiculeRequest vehiculeRequest, UUID trakingId) {
        // Trouver le client existant par trackingId
    	Vehicule existingVehicule = vehiculeRepository.findByTrakingId(trakingId)
                .orElseThrow(() -> new RuntimeException("Le vehicule avec cet identifiant n'existe pas"));

        // Mettre à jour les informations du client avec les données du ClientRequest
        existingVehicule.setModele(vehiculeRequest.getModele());
        

        // Sauvegarder les modifications
        Vehicule updatedVehicule= vehiculeRepository.save(existingVehicule);
        
        // Retourner la réponse mise à jour
        return vehiculeMapper.toResponse(updatedVehicule);
    }

    @Override
    public void delete(UUID idVehicule) {
        // Trouver le client à supprimer
    	Vehicule vehiculeToDelete = vehiculeRepository.findByTrakingId(idVehicule)
                .orElseThrow(() -> new RuntimeException("Le vehicule avec cet identifiant n'existe pas"));
        
        // Supprimer le client
    	vehiculeRepository.delete(vehiculeToDelete);
    }

    @Override
    public List<VehiculeResponse> listeVehicule() {
        // Récupérer la liste de tous les clients ordonnée par nom et mapper vers ClientResponse
        return vehiculeRepository.findAllVehiculesOrderedByVehicule()
                .stream()
                .map(vehiculeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
