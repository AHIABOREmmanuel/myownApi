package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;
import lenuel.Apps.admin.service.CommissariatService;

@RestController
@RequestMapping("/api/commissariats")
@CrossOrigin(origins = "*")
@Tag(name = "Commissariats", description = "API pour gérer les commissariats")
public class CommissariatController {

    private final CommissariatService commissariatService;

    public CommissariatController(CommissariatService commissariatService) {
        this.commissariatService = commissariatService;
    }

    // Créer un commissariat
    @PostMapping
    @Operation(summary = "Créer un commissariat", description = "Ajoute un nouveau commissariat avec les informations fournies.")
    public ResponseEntity<CommissariatResponse> createCommissariat(@RequestBody CommissariatRequest commissariatRequest) {
        CommissariatResponse createCommissariat = commissariatService.createCommissariat(commissariatRequest);
        return ResponseEntity.ok(createCommissariat);
    }

    // Mettre à jour un commissariat
    @PutMapping("/{trackingId}")
    @Operation(summary = "Mettre à jour un commissariat", description = "Met à jour les informations d'un commissariat spécifique.")
    public ResponseEntity<CommissariatResponse> updateCommissariat(
            @PathVariable UUID trackingId,
            @RequestBody CommissariatRequest commissariatRequest
    ) {
        CommissariatResponse updateCommissariat = commissariatService.updateCommissariat(commissariatRequest, trackingId);
        return ResponseEntity.ok(updateCommissariat);
    }

    //  Supprimer un commissariat
    @DeleteMapping("/{idCommissariat}")
    @Operation(summary = "Supprimer un commissariat", description = "Supprime un commissariat de la base de données.")
    public ResponseEntity<Void> deleteCommissariat(@PathVariable UUID idCommissariat) {
        commissariatService.delete(idCommissariat);
        return ResponseEntity.noContent().build(); 
    }

    // Liste des commissariats
    @GetMapping
    @Operation(summary = "Lister tous les commissariats", description = "Retourne la liste complète des commissariats enregistrés.")
    public ResponseEntity<List<CommissariatResponse>> getAllCommissariats() {
        List<CommissariatResponse> commissariats = commissariatService.listeCommissariat();
        return ResponseEntity.ok(commissariats);
    }
}
