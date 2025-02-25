package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;
import lenuel.Apps.admin.dto.response.VehiculeResponse;
import lenuel.Apps.admin.service.CommissariatService;

@RestController
@RequestMapping("/api/commissariats")
@CrossOrigin(origins = "http://localhost:4200")
public class CommissariatController {

    private final CommissariatService commissariatService;

   
    public CommissariatController(CommissariatService commissariatService) {
        this.commissariatService = commissariatService;
    }

    // Créer un commissariat
    @PostMapping
    public ResponseEntity<CommissariatResponse> createCommissariat(@RequestBody CommissariatRequest commissariatRequest) {
        CommissariatResponse createCommissariat = commissariatService.createCommissariat(commissariatRequest);
        return ResponseEntity.ok(createCommissariat);
    }

    // Mettre à jour un commissariat
    @PutMapping("/{trackingId}")
    public ResponseEntity<CommissariatResponse> updateCommissariat(
            @PathVariable UUID trackingId,
            @RequestBody CommissariatRequest commissariatRequest
    ) {
        CommissariatResponse updateCommissariat = commissariatService.updateCommissariat(commissariatRequest, trackingId);
        return ResponseEntity.ok(updateCommissariat);
    }

    // Supprimer un commissariat
    @DeleteMapping("/{idCommissariat}")
    public ResponseEntity<Void> deleteCommissariat(@PathVariable UUID idCommissariat) {
        commissariatService.delete(idCommissariat);
        return ResponseEntity.noContent().build(); // Code 204
    }

    // Liste des commissariatss
    
    @GetMapping
    public ResponseEntity<List<CommissariatResponse>> getAllCommissariats() {
        List<CommissariatResponse> commissariats =commissariatService.listeCommissariat();
        return ResponseEntity.ok(commissariats);
    }
}
