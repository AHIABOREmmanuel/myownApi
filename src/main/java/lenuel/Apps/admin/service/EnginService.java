package lenuel.Apps.admin.service;

import java.util.List;
import java.util.UUID;

import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.request.EnginRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;
import lenuel.Apps.admin.dto.response.EnginResponse;

public interface EnginService {

	
	public EnginResponse createEngin(EnginRequest enginRequest  );
	
	
	public EnginResponse updateEngin( EnginRequest enginRequest , UUID trakingId);
	
	public void delete(UUID trakingId);
	
	public List<EnginResponse> listeEngin();
	
	public List<EnginResponse> findEnginOrderedByImmatriculation(String immatriculation);
	
}
