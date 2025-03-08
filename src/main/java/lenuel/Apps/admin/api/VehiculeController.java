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

import lenuel.Apps.admin.dto.request.VehiculeRequest;
import lenuel.Apps.admin.dto.response.VehiculeResponse;
import lenuel.Apps.admin.services.impls.VehiculeServiceImplement;


@RestController
@RequestMapping("/api/vehicules")
@CrossOrigin(origins = "*")
public class VehiculeController {

	
	 private final  VehiculeServiceImplement vehiculeService;

	    
	    public VehiculeController(VehiculeServiceImplement vehiculeService) {
	        this.vehiculeService = vehiculeService;
	    }

	    // Créer un vehicule
	    @PostMapping
	    public ResponseEntity<VehiculeResponse> createVehicule(@RequestBody VehiculeRequest vehiculeRequest) {
	    	VehiculeResponse createdVehicule = vehiculeService.createVehicule(vehiculeRequest);
	        return ResponseEntity.ok(createdVehicule);
	    }

	    // Mettre à jour un client
	    @PutMapping("/{trakingId}")
	    public ResponseEntity<VehiculeResponse> updateVehicule(
	            @PathVariable UUID trakingId,
	            @RequestBody VehiculeRequest vehiculeRequest
	    ) {
	    	VehiculeResponse updatedVehicule = vehiculeService.updateVehicule(vehiculeRequest, trakingId);
	        return ResponseEntity.ok(updatedVehicule);
	    }

	    // Supprimer un client
	    @DeleteMapping("/{idVehicule}")
	    public ResponseEntity<Void> deleteVehicule(@PathVariable UUID idVehicule) {
	    	vehiculeService.delete(idVehicule);
	        return ResponseEntity.noContent().build();
	    }

	    // Liste des clients
	    @GetMapping
	    public ResponseEntity<List<VehiculeResponse>> getAllVehicules() {
	        List<VehiculeResponse> vehicules = vehiculeService.listeVehicule();
	        return ResponseEntity.ok(vehicules);
	    }
}
