package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lenuel.Apps.admin.dto.request.MotifRequest;
import lenuel.Apps.admin.dto.response.MotifResponse;
import lenuel.Apps.admin.service.MotifService;

@RestController
@RequestMapping("/api/motifs")
@CrossOrigin(origins = "*")
@Tag(name = "Motifs", description = "API pour gérer les motifs de saisie")
public class MotifController {

    private final MotifService motifService;

    public MotifController(MotifService motifService) {
        this.motifService = motifService;
    }

    //  Créer un motif
    @PostMapping
    @Operation(summary = "Créer un motif", description = "Ajoute un nouveau motif avec les informations fournies.")
    public ResponseEntity<MotifResponse> createMotif(@RequestBody MotifRequest motifRequest) {
        MotifResponse createMotif = motifService.createMotif(motifRequest);
        return ResponseEntity.ok(createMotif);
    }

    //  Mettre à jour un motif
    @PutMapping("/{trackingId}")
    @Operation(summary = "Mettre à jour un motif", description = "Modifie les informations d'un motif spécifique.")
    public ResponseEntity<MotifResponse> updateMotif(
            @PathVariable UUID trackingId,
            @RequestBody MotifRequest motifRequest) {
        MotifResponse updateMotif = motifService.updateMotif(motifRequest, trackingId);
        return ResponseEntity.ok(updateMotif);
    }

    //  Supprimer un motif
    @DeleteMapping("/{idMotif}")
    @Operation(summary = "Supprimer un motif", description = "Supprime un motif de la base de données.")
    public ResponseEntity<Void> deleteMotif(@PathVariable UUID idMotif) {
        motifService.delete(idMotif);
        return ResponseEntity.noContent().build();
    }

    //  Liste des motifs
    @GetMapping
    @Operation(summary = "Lister tous les motifs", description = "Retourne la liste complète des motifs disponibles.")
    public ResponseEntity<List<MotifResponse>> getAllMotifs() {
        List<MotifResponse> motifs = motifService.listeMotif();
        return ResponseEntity.ok(motifs);
    }
}
