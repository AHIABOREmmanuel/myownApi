package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lenuel.Apps.admin.dto.request.MotifRequest;
import lenuel.Apps.admin.dto.response.MotifResponse;
import lenuel.Apps.admin.service.MotifService;

@RestController
@RequestMapping("/api/motifs")
@CrossOrigin(origins = "*")
public class MotifController {

	 private final MotifService motifService;

	    
	    public MotifController(MotifService motifService) {
	        this.motifService = motifService;
	    }

	    // Créer un motif
	    @PostMapping
	    public ResponseEntity<MotifResponse> createMotif(@RequestBody MotifRequest motifRequest) {
	    	MotifResponse createMotif = motifService.createMotif(motifRequest);
	        return ResponseEntity.ok(createMotif);
	    }

	    // Mettre à jour un motif
	    @PutMapping("/{trackingId}")
	    public ResponseEntity<MotifResponse> updateMotif(
	            @PathVariable UUID trackingId,
	            @RequestBody MotifRequest motifRequest
	    ) {
	    	MotifResponse updateMotif = motifService.updateMotif(motifRequest, trackingId);
	        return ResponseEntity.ok(updateMotif);
	    }

	    // Supprimer un motif
	    @DeleteMapping("/{idMotif}")
	    public ResponseEntity<Void> deleteMotif(@PathVariable UUID idMotif) {
	    	motifService.delete(idMotif);
	        return ResponseEntity.noContent().build(); 
	    }

	    // Liste des motifs
	    @GetMapping
	    public ResponseEntity<List<MotifResponse>> getAllMotifs() {
	        List<MotifResponse> motifs =motifService.listeMotif();
	        return ResponseEntity.ok(motifs);
	    }
}
