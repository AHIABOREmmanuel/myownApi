package lenuel.Apps.admin.services.impls;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;	
import jakarta.transaction.Transactional;
import lenuel.Apps.admin.dto.request.EnginRequest;
import lenuel.Apps.admin.dto.response.EnginResponse;
import lenuel.Apps.admin.entity.Engin;
import lenuel.Apps.admin.mappers.EnginMapper;
import lenuel.Apps.admin.repository.EnginRepository;
import lenuel.Apps.admin.service.EnginService;

@Service
@Transactional
public class EnginServiceImplement implements EnginService {

    private final EnginRepository enginRepository;
    private final EnginMapper enginMapper;

    // Injection des dépendances
    public EnginServiceImplement(EnginRepository enginRepository, EnginMapper enginMapper) {
        this.enginRepository = enginRepository;
        this.enginMapper = enginMapper;
    }


    @Override
    public EnginResponse createEngin(EnginRequest enginRequest) {
    	Engin EnginEntity = enginMapper.toEntity(enginRequest);
        
        // Sauvegarder l'entité Client dans la base de données
    	Engin savedEngin = enginRepository.save(EnginEntity);
        
        // Convertir l'entité Client sauvegardée en ClientResponse et retourner
        return enginMapper.toResponse(savedEngin);
    }


	@Override
	public EnginResponse updateEngin(EnginRequest enginRequest, UUID trakingId) {
		Engin engin = enginRepository.findByTrakingId(trakingId).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		Engin v = enginRepository.save(engin);
		return enginMapper.toResponse(v);
	}

	@Override
	public void delete(UUID idEngin) {
		if(idEngin == null) {
			throw new RuntimeException("Cet Engin n'existe pas");
		}
		Engin e = enginRepository.findByTrakingId(idEngin).orElseThrow(()-> new RuntimeException("L'identifiant n'existe pas"));
		
		enginRepository.delete(e);
		
	}

	@Override
	public List<EnginResponse> listeEngin() {
		return enginRepository.findAllEnginOrderedByImmatriculation()
				.stream()
				.map(enginMapper::toResponse)
				.toList();
	}
	
	public EnginResponse findById(UUID trakingId) {
        Engin engin = enginRepository.findByTrakingId(trakingId)
            .orElseThrow(() -> new RuntimeException("L'identifiant n'existe pas"));
        return enginMapper.toResponse(engin);
    }


	@Override
	public List<EnginResponse> findEnginOrderedByImmatriculation(String immatriculation) {
		return enginRepository.findEnginOrderedByImmatriculation(immatriculation)
				.stream()
				.map(enginMapper::toResponse)
				.toList();
	}
	
	
	
}
