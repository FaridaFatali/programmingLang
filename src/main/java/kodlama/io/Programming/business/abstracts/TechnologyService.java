package kodlama.io.Programming.business.abstracts;

import java.util.List;
import kodlama.io.Programming.business.requests.TechnologyRequest;
import kodlama.io.Programming.business.responses.TechnologyResponse;

public interface TechnologyService {
    List<TechnologyResponse> getAll();
    
    void add(TechnologyRequest technologyRequest);
    void delete(int id);
    void update(int id, TechnologyRequest technologyRequest);
    TechnologyResponse getResponseById(int id);
}
