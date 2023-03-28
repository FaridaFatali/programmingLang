package kodlama.io.Programming.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import kodlama.io.Programming.business.abstracts.LanguageService;
import kodlama.io.Programming.business.requests.CreateLanguageRequest;
import kodlama.io.Programming.business.requests.UpdateLanguageRequest;
import kodlama.io.Programming.business.responses.GetAllLanguagesResponse;
import kodlama.io.Programming.business.responses.GetByIdLanguageResponse;
import kodlama.io.Programming.business.rules.LanguageBusinessRules;
import kodlama.io.Programming.core.utilities.mappers.ModelMapperService;
import kodlama.io.Programming.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Programming.entities.concretes.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{
    private LanguageRepository languageRepository;
    private ModelMapperService modelMapperService;
    private LanguageBusinessRules languageBusinessRules;
    
    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponse = languages.stream()
                .map(language->this.modelMapperService.forResponse()
                .map(language, GetAllLanguagesResponse.class)).collect(Collectors.toList());
        
        return languagesResponse;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        this.languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getName());
        
        Language language = this.modelMapperService.forRequest()
                .map(createLanguageRequest, Language.class);
        this.languageRepository.save(language);
    }

    @Override
    public void delete(int id) {
        this.languageRepository.deleteById(id);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        Language language = this.modelMapperService.forRequest()
                .map(updateLanguageRequest, Language.class);
        
        this.languageRepository.save(language);
    }

    @Override
    public GetByIdLanguageResponse getById(int id) {
        Language language = this.languageRepository.findById(id).orElseThrow();
        GetByIdLanguageResponse languageResponse = this.modelMapperService
                .forResponse().map(language, GetByIdLanguageResponse.class);
        
        return languageResponse;
    }


}

