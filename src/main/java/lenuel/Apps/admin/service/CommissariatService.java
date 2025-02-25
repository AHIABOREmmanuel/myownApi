package lenuel.Apps.admin.service;

import java.util.List;
import java.util.UUID;

import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;



public interface CommissariatService {

	
	public CommissariatResponse createCommissariat(CommissariatRequest commissariatRequest  );
	
	
	public CommissariatResponse updateCommissariat( CommissariatRequest commissariatRequest , UUID trakingId);
	
	public void delete(UUID trakingId);
	
	public List<CommissariatResponse> listeCommissariat();
	
}
