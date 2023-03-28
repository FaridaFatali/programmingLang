package kodlama.io.Programming.business.abstracts;

import java.util.List;
import kodlama.io.Programming.business.requests.CreateTechnologyRequest;
import kodlama.io.Programming.business.requests.UpdateTechnologyRequest;
import kodlama.io.Programming.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Programming.business.responses.GetByIdTechnologyResponse;

public interface TechnologyService {
    List<GetAllTechnologiesResponse> getAll();
    GetByIdTechnologyResponse getById(int id);
    void add(CreateTechnologyRequest createTechnologyRequest);
    void update(UpdateTechnologyRequest updateTechnologyRequest);
    void delete(int id);
//    void update(int id, TechnologyRequest technologyRequest);
//    TechnologyResponse getResponseById(int id);
}