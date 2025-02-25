package lenuel.Apps.admin.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;
import lenuel.Apps.admin.dto.request.EnginRequest;
import lenuel.Apps.admin.dto.response.EnginResponse;
import lenuel.Apps.admin.entity.Commissariat;
import lenuel.Apps.admin.entity.Engin;
import lenuel.Apps.admin.entity.Motif;
import lenuel.Apps.admin.entity.ResourceNotFoundException;
import lenuel.Apps.admin.entity.Vehicule;
import lenuel.Apps.admin.repository.CommissariatRepository;
import lenuel.Apps.admin.repository.MotifRepository;
import lenuel.Apps.admin.repository.VehiculeRepository;
@Component
public class EnginMapper {

    private final CommissariatRepository commissariatRepository;
    private final VehiculeRepository vehiculeRepository;
    private final MotifRepository motifRepository;

    public EnginMapper(
        CommissariatRepository commissariatRepository,
        VehiculeRepository vehiculeRepository,
        MotifRepository motifRepository
    ) {
        this.commissariatRepository = commissariatRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.motifRepository = motifRepository;
    }

    public Engin toEntity(EnginRequest enginRequest) {
        Engin engin = new Engin();
        engin.setImmatriculation(enginRequest.getImmatriculation());
        engin.setTrakingId(UUID.randomUUID());

        // Récupérer et valider le Commissariat
        Commissariat commissariat = commissariatRepository.findByTrakingId(enginRequest.getCommissariatId())
            .orElseThrow(() -> new ResourceNotFoundException("Commissariat non trouvé avec le trakingId : " + enginRequest.getCommissariatId()));
        engin.setCommissariat(commissariat);

        // Récupérer et valider le Vehicule
        Vehicule vehicule = vehiculeRepository.findByTrakingId(enginRequest.getVehiculeId())
            .orElseThrow(() -> new ResourceNotFoundException("Véhicule non trouvé avec le trakingId : " + enginRequest.getVehiculeId()));
        engin.setVehicule(vehicule);

        // Récupérer et valider le Motif
        Motif motif = motifRepository.findByTrakingId(enginRequest.getMotifId())
            .orElseThrow(() -> new ResourceNotFoundException("Motif non trouvé avec le trakingId : " + enginRequest.getMotifId()));
        engin.setMotif(motif);

        return engin;
    }

    public EnginResponse toResponse(Engin engin) {
        EnginResponse enginResponse = new EnginResponse();
        enginResponse.setTrakingId(engin.getTrakingId());
        enginResponse.setImmatriculation(engin.getImmatriculation());

        // Vérifier que les objets liés ne sont pas null avant d'accéder à leurs propriétés
        if (engin.getCommissariat() != null) {
            enginResponse.setCommissariat(engin.getCommissariat().getArrondissement());
        }
        if (engin.getVehicule() != null) {
            enginResponse.setVehicule(engin.getVehicule().getModele());
        }
        if (engin.getMotif() != null) {
            enginResponse.setMotif(engin.getMotif().getMotif());
        }

        return enginResponse;
    }
}