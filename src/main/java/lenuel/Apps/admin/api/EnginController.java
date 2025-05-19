package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lenuel.Apps.admin.dto.request.EnginRequest;
import lenuel.Apps.admin.dto.response.EnginResponse;
import lenuel.Apps.admin.service.EnginService;

@RestController
@RequestMapping("/api/engins")
@CrossOrigin(origins = "*")
@Tag(name = "Engins", description = "API pour gérer les engins saisis")
public class EnginController {

    private final EnginService enginService;

    public EnginController(EnginService enginService) {
        this.enginService = enginService;
    }

    //  Créer un engin
    @PostMapping
    @Operation(summary = "Créer un engin", description = "Ajoute un nouvel engin avec les informations fournies.")
    public ResponseEntity<EnginResponse> createEngin(@RequestBody EnginRequest enginRequest) {
        EnginResponse enginResponse = enginService.createEngin(enginRequest);
        return new ResponseEntity<>(enginResponse, HttpStatus.CREATED);
    }

    //  Mettre à jour un engin
    @PutMapping("/{trackingId}")
    @Operation(summary = "Mettre à jour un engin", description = "Modifie les informations d'un engin spécifique.")
    public ResponseEntity<EnginResponse> updateEngin(
            @RequestBody EnginRequest enginRequest, 
            @PathVariable UUID trackingId) {
        EnginResponse enginResponse = enginService.updateEngin(enginRequest, trackingId);
        return new ResponseEntity<>(enginResponse, HttpStatus.OK);
    }

    //  Supprimer un engin
    @DeleteMapping("/{idEngin}")
    @Operation(summary = "Supprimer un engin", description = "Supprime un engin de la base de données.")
    public ResponseEntity<Void> deleteEngin(@PathVariable UUID idEngin) {
        enginService.delete(idEngin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //  Liste de tous les engins
    @GetMapping
    @Operation(summary = "Lister tous les engins", description = "Retourne la liste complète des engins saisis.")
    public ResponseEntity<List<EnginResponse>> getAllEngins() {
        List<EnginResponse> enginResponses = enginService.listeEngin();
        return new ResponseEntity<>(enginResponses, HttpStatus.OK);
    }

    //  Rechercher un engin par son immatriculation
    @GetMapping("/{immatriculation}")
    @Operation(summary = "Rechercher un engin par immatriculation", description = "Retourne les engins correspondant à une immatriculation donnée.")
    public ResponseEntity<List<EnginResponse>> findEnginOrderedByImmatriculation(@PathVariable String immatriculation) {
        List<EnginResponse> enginResponses = enginService.findEnginOrderedByImmatriculation(immatriculation);
        return new ResponseEntity<>(enginResponses, HttpStatus.OK);
    }
}
