package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lenuel.Apps.admin.dto.request.VehiculeRequest;
import lenuel.Apps.admin.dto.response.VehiculeResponse;
import lenuel.Apps.admin.services.impls.VehiculeServiceImplement;

@RestController
@RequestMapping("/api/vehicules")
@CrossOrigin(origins = "*")
@Tag(name = "Véhicules", description = "API pour gérer les véhicules")
public class VehiculeController {

    private final VehiculeServiceImplement vehiculeService;

    public VehiculeController(VehiculeServiceImplement vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    //  Créer un véhicule
    @PostMapping
    @Operation(summary = "Créer un véhicule", description = "Ajoute un nouveau véhicule avec les informations fournies.")
    public ResponseEntity<VehiculeResponse> createVehicule(@RequestBody VehiculeRequest vehiculeRequest) {
        VehiculeResponse createdVehicule = vehiculeService.createVehicule(vehiculeRequest);
        return ResponseEntity.ok(createdVehicule);
    }

    //  Mettre à jour un véhicule
    @PutMapping("/{trackingId}")
    @Operation(summary = "Mettre à jour un véhicule", description = "Modifie les informations d'un véhicule existant.")
    public ResponseEntity<VehiculeResponse> updateVehicule(
            @PathVariable UUID trackingId,
            @RequestBody VehiculeRequest vehiculeRequest) {
        VehiculeResponse updatedVehicule = vehiculeService.updateVehicule(vehiculeRequest, trackingId);
        return ResponseEntity.ok(updatedVehicule);
    }

    //  Supprimer un véhicule
    @DeleteMapping("/{idVehicule}")
    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule de la base de données.")
    public ResponseEntity<Void> deleteVehicule(@PathVariable UUID idVehicule) {
        vehiculeService.delete(idVehicule);
        return ResponseEntity.noContent().build();
    }

    //  Liste des véhicules
    @GetMapping
    @Operation(summary = "Lister tous les véhicules", description = "Retourne la liste complète des véhicules.")
    public ResponseEntity<List<VehiculeResponse>> getAllVehicules() {
        List<VehiculeResponse> vehicules = vehiculeService.listeVehicule();
        return ResponseEntity.ok(vehicules);
    }
}
