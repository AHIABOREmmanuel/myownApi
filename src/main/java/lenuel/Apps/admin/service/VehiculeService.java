package lenuel.Apps.admin.service;

import java.util.List;
import java.util.UUID;

import lenuel.Apps.admin.dto.request.VehiculeRequest;
import lenuel.Apps.admin.dto.response.VehiculeResponse;



public interface VehiculeService {

	
	public VehiculeResponse createVehicule(VehiculeRequest vehiculeRequest  );
	
	
	public VehiculeResponse updateVehicule( VehiculeRequest vehiculeRequest , UUID trakingId);
	
	public void delete(UUID idVehicule);
	
	public List<VehiculeResponse> listeVehicule();
	
}
