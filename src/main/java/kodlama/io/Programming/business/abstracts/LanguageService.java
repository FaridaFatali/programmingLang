package kodlama.io.Programming.business.abstracts;

import java.util.List;
import kodlama.io.Programming.business.requests.CreateLanguageRequest;
import kodlama.io.Programming.business.requests.UpdateLanguageRequest;
import kodlama.io.Programming.business.responses.GetAllLanguagesResponse;
import kodlama.io.Programming.business.responses.GetByIdLanguageResponse;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();
    GetByIdLanguageResponse getById(int id);
    void add(CreateLanguageRequest createLanguageRequest);
    void update(UpdateLanguageRequest updateLanguageRequest);
    void delete(int id);

}
