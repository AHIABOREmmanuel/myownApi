package lenuel.Apps.admin.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lenuel.Apps.admin.dto.request.MotifRequest;
import lenuel.Apps.admin.dto.response.MotifResponse;
import lenuel.Apps.admin.entity.Motif;


@Component 
public class MotifMapper {
	public Motif toEntity(MotifRequest dto){
		Motif m= new Motif();
        m.setMotif(dto.getMotif());
        m.setTrakingId(UUID.randomUUID());
        return m;
    }
    
    public MotifResponse toResponse(Motif r) {
    	MotifResponse response = new MotifResponse();
    	response.setMotif(r.getMotif());
    	response.setmotifResponseTrakingId(r.getTrakingId());
		return response;
    	
    }
}