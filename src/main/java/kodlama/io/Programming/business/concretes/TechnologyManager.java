package kodlama.io.Programming.business.concretes;

import java.util.ArrayList;
import java.util.List;
import kodlama.io.Programming.business.abstracts.TechnologyService;
import kodlama.io.Programming.business.requests.TechnologyRequest;
import kodlama.io.Programming.business.responses.TechnologyResponse;
import kodlama.io.Programming.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Programming.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechnologyManager  implements TechnologyService{
    private TechnologyRepository technologyRepository;
    
    @Autowired
    public TechnologyManager(TechnologyRepository technologyRepository){
        this.technologyRepository = technologyRepository;
    }
    
    @Override
    public List<TechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<TechnologyResponse> technologyResponse = new ArrayList<TechnologyResponse>();
        
        for(Technology technology : technologies){
            TechnologyResponse responseTechnology = new TechnologyResponse();
            responseTechnology.setId(technology.getId());
            responseTechnology.setName(technology.getName());
            technologyResponse.add(responseTechnology);
        }
        return technologyResponse;
    }

    @Override
    public void add(TechnologyRequest technologyRequest) {
        Technology technology = new Technology();
        technology.setName(technologyRequest.getName());
        this.technologyRepository.save(technology);
    }
    
    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }

    @Override
    public void update(int id, TechnologyRequest technologyRequest) {
        Technology technology = technologyRepository.findById(id);
        technology.setName(technologyRequest.getName());
        technologyRepository.save(technology);
    }

    public Technology getById(int id) {
        return null;
    }

    @Override
    public TechnologyResponse getResponseById(int id) {
       Technology technology = technologyRepository.findById(id);
       TechnologyResponse technologyResponse = new TechnologyResponse();
       technologyRepository.findById(technologyResponse.getId());
       return technologyResponse;
    }
}
