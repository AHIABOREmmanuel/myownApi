package lenuel.Apps.admin.service;

import java.util.List;
import java.util.UUID;

import lenuel.Apps.admin.dto.request.MotifRequest;
import lenuel.Apps.admin.dto.response.MotifResponse;

public interface MotifService {

	
	public MotifResponse createMotif(MotifRequest motifRequest  );
	
	
	public MotifResponse updateMotif( MotifRequest motifRequest , UUID trakingId);
	
	public void delete(UUID trakingId);
	
	public List<MotifResponse> listeMotif();
	
}
