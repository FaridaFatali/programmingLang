package kodlama.io.Programming.business.rules;

import kodlama.io.Programming.core.utilities.exceptions.BusinessException;
import kodlama.io.Programming.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {
    private LanguageRepository languageRepository;
    
    public void checkIfLanguageNameExists(String name){
        if(this.languageRepository.existsByName(name)){
            throw new BusinessException("Language name already exists");
        }
    }
}
