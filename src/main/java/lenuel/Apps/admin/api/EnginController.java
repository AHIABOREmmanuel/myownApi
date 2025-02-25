package lenuel.Apps.admin.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.request.EnginRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;
import lenuel.Apps.admin.dto.response.EnginResponse;
import lenuel.Apps.admin.service.CommissariatService;
import lenuel.Apps.admin.service.EnginService;

@RestController
@RequestMapping("/api/engins")
@CrossOrigin(origins = "*")
public class EnginController {


    private final EnginService enginService;

    @Autowired
    public EnginController(EnginService enginService) {
        this.enginService = enginService;
    }

    // Créer une vente
    @PostMapping
    public ResponseEntity<EnginResponse> createEngin(@RequestBody EnginRequest enginRequest) {
    	EnginResponse enginResponse = enginService.createEngin(enginRequest);
        return new ResponseEntity<>(enginResponse, HttpStatus.CREATED);
    }

    // Mettre à jour un engin
    @PutMapping("/{trakingId}")
    public ResponseEntity<EnginResponse> updateEngin(
            @RequestBody EnginRequest enginRequest, 
            @PathVariable UUID trakingId) {
    	EnginResponse enginResponse = enginService.updateEngin(enginRequest, trakingId);
        return new ResponseEntity<>(enginResponse, HttpStatus.OK);
    }

    // Supprimer une vente
    @DeleteMapping("/{idEngin}")
    public ResponseEntity<Void> deleteEngin(@PathVariable UUID idEngin) {
    	enginService.delete(idEngin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Liste des ventes
    @GetMapping
    public ResponseEntity<List<EnginResponse>> getAllEngins() {
        List<EnginResponse> enginResponses = enginService.listeEngin();
        return new ResponseEntity<>(enginResponses, HttpStatus.OK);
    }


    public ResponseEntity<List<EnginResponse>> findAllEnginOrderedByImmatriculation() {
        List<EnginResponse> enginResponses = enginService.listeEngin();
        return new ResponseEntity<>(enginResponses, HttpStatus.OK);
    }
    

    @GetMapping("/{immatriculation}")
    public ResponseEntity<List<EnginResponse>> findEnginOrderedByImmatriculation(@PathVariable String immatriculation) {
        List<EnginResponse> enginResponses = enginService.findEnginOrderedByImmatriculation(immatriculation);
        return new ResponseEntity<>(enginResponses, HttpStatus.OK);
    }

}