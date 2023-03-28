package kodlama.io.Programming.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import kodlama.io.Programming.business.abstracts.TechnologyService;
import kodlama.io.Programming.business.requests.CreateTechnologyRequest;
import kodlama.io.Programming.business.requests.UpdateTechnologyRequest;
import kodlama.io.Programming.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Programming.business.responses.GetByIdTechnologyResponse;
import kodlama.io.Programming.core.utilities.mappers.ModelMapperService;
import kodlama.io.Programming.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Programming.entities.concretes.Technology;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TechnologyManager  implements TechnologyService{
    private TechnologyRepository technologyRepository;
    private ModelMapperService modelMapperService;
    
    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> technologiesResponse = technologies.stream()
                .map(technology->this.modelMapperService.forResponse()
                .map(technology, GetAllTechnologiesResponse.class)).collect(Collectors.toList());
        
        return technologiesResponse;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        Technology technology = this.modelMapperService.forRequest()
                .map(createTechnologyRequest, Technology.class);
        this.technologyRepository.save(technology);
    }

    @Override
    public void delete(int id) {
        this.technologyRepository.deleteById(id);
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = this.modelMapperService.forRequest()
                .map(updateTechnologyRequest, Technology.class);
        
        this.technologyRepository.save(technology);
    }

    @Override
    public GetByIdTechnologyResponse getById(int id){
        Technology technology = this.technologyRepository.findById(id);
        GetByIdTechnologyResponse technologyResponse = this.modelMapperService
                .forResponse().map(technology, GetByIdTechnologyResponse.class);
        
        return technologyResponse;
    }
}
