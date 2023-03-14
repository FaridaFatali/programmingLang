package kodlama.io.Programming.business.concretes;

import java.util.ArrayList;
import java.util.List;
import kodlama.io.Programming.business.abstracts.LanguageService;
import kodlama.io.Programming.business.requests.LanguageRequest;
import kodlama.io.Programming.business.responses.LanguageResponse;
import kodlama.io.Programming.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Programming.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager  implements LanguageService{
private LanguageRepository languageRepository;
    
    @Autowired
    public LanguageManager(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    
    @Override
    public List<LanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<LanguageResponse> languageResponse = new ArrayList<LanguageResponse>();
        
        for(Language language : languages){
            LanguageResponse responseLanguage = new LanguageResponse();
            responseLanguage.setId(language.getId());
            responseLanguage.setName(language.getName());
            languageResponse.add(responseLanguage);
        }
        return languageResponse;
    }

    @Override
    public void add(LanguageRequest languageRequest) {
        Language language = new Language();
        language.setName(languageRequest.getName());
        this.languageRepository.save(language);
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void update(int id, LanguageRequest languageRequest) {
        Language language = languageRepository.findById(id);
        language.setName(languageRequest.getName());
        languageRepository.save(language);
    }

    @Override
    public Language getById(int id) {
        return null;
    }

    @Override
    public LanguageResponse getResponseById(int id) {
       Language language = languageRepository.findById(id);
       LanguageResponse languageResponse = new LanguageResponse();
       languageRepository.findById(languageResponse.getId());
       return languageResponse;
    }
    
}

