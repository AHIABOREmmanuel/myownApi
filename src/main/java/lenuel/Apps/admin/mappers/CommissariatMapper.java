package lenuel.Apps.admin.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lenuel.Apps.admin.dto.request.CommissariatRequest;
import lenuel.Apps.admin.dto.response.CommissariatResponse;
import lenuel.Apps.admin.entity.Commissariat;

@Component
public class CommissariatMapper {
	public Commissariat toEntity(CommissariatRequest dto){
		Commissariat c= new Commissariat();
        c.setArrondissement(dto.getArrondissement());
        c.setAdresse(dto.getAdresse());
        c.setTel(dto.getTel());
        c.setTrakingId(UUID.randomUUID());
        return c;
    }
    
    public CommissariatResponse toResponse(Commissariat r) {
    	CommissariatResponse response = new CommissariatResponse();
    	response.setArrondissement(r.getArrondissement());
    	response.setAdresse(r.getAdresse());
    	response.setTel(r.getTel());
    	response.setCommissariatResponseTrakingId(r.getTrakingId());
		return response;
    	
    }
}
