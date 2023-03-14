package kodlama.io.Programming.business.abstracts;

import java.util.List;
import kodlama.io.Programming.business.requests.LanguageRequest;
import kodlama.io.Programming.business.responses.LanguageResponse;
import kodlama.io.Programming.entities.concretes.Language;

public interface LanguageService {
    List<LanguageResponse> getAll();
    
    LanguageResponse getResponseById(int id);
    
    Language getById(int id);
    
    void add(LanguageRequest languageRequest);
    void delete(int id);
    void update(int id, LanguageRequest languageRequest);
}
