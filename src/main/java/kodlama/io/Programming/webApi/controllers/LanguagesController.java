package kodlama.io.Programming.webApi.controllers;

import java.util.List;
import javax.validation.Valid;
import kodlama.io.Programming.business.abstracts.LanguageService;
import kodlama.io.Programming.business.requests.CreateLanguageRequest;
import kodlama.io.Programming.business.requests.UpdateLanguageRequest;
import kodlama.io.Programming.business.responses.GetAllLanguagesResponse;
import kodlama.io.Programming.business.responses.GetByIdLanguageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {
    private LanguageService languageService;
        
    @GetMapping()
    public List<GetAllLanguagesResponse> getAll(){
        return languageService.getAll();
    }
    
    @GetMapping("/{id}")
    public GetByIdLanguageResponse getById(@PathVariable int id){
        return languageService.getById(id);
    }
    
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateLanguageRequest createLanguageRequest) throws Exception{
        this.languageService.add(createLanguageRequest);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        this.languageService.delete(id);
    }
    
    @PutMapping()
    public void update(@RequestBody() UpdateLanguageRequest updateLanguageRequest){
        this.languageService.update(updateLanguageRequest);
    }
   

}

