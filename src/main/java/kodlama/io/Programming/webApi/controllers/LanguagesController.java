package kodlama.io.Programming.webApi.controllers;

import java.util.List;
import kodlama.io.Programming.business.abstracts.LanguageService;
import kodlama.io.Programming.business.requests.LanguageRequest;
import kodlama.io.Programming.business.responses.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;
    
    @Autowired
    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @GetMapping("/getall")
    public List<LanguageResponse> getAll(){
        return languageService.getAll();
    }
    
    @PostMapping("/add")
    public void add(@RequestBody LanguageRequest languageRequest)throws Exception{
        this.languageService.add(languageRequest);
    }
    
    @DeleteMapping("/delete")
    public void delete(int id){
        this.languageService.delete(id);
    }
    
    @PutMapping("/update")
    public void update(int id, LanguageRequest languageRequest){
        this.languageService.update(id, languageRequest);
    }
    
    @GetMapping("/get")
    public LanguageResponse getById(int id){
        return languageService.getResponseById(id);
    }
}
