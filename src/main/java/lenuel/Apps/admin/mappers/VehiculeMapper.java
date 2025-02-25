package lenuel.Apps.admin.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lenuel.Apps.admin.dto.request.VehiculeRequest;
import lenuel.Apps.admin.dto.response.VehiculeResponse;
import lenuel.Apps.admin.entity.Vehicule;

@Component 
public class VehiculeMapper {
	
	
	public Vehicule toEntity(VehiculeRequest dto){
		Vehicule v= new Vehicule();
        v.setModele(dto.getModele());
        v.setTrakingId(UUID.randomUUID());
        return v;
    }
    
    public VehiculeResponse toResponse(Vehicule r) {
    	VehiculeResponse response = new VehiculeResponse();
    	response.setModele(r.getModele());
    	response.setVehiculeResponseTrakingId(r.getTrakingId());
		return response;
    	
    }
}