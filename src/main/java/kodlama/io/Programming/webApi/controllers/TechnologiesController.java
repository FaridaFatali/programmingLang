package kodlama.io.Programming.webApi.controllers;

import java.util.List;
import javax.validation.Valid;
import kodlama.io.Programming.business.abstracts.TechnologyService;
import kodlama.io.Programming.business.requests.CreateTechnologyRequest;
import kodlama.io.Programming.business.requests.UpdateTechnologyRequest;
import kodlama.io.Programming.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Programming.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {
    private TechnologyService technologyService;
    
    @GetMapping()
    public List<GetAllTechnologiesResponse> getAll(){
        return technologyService.getAll();
    }
    
    @GetMapping("/{id}")
    public GetByIdTechnologyResponse getById(@PathVariable int id) throws Exception{
        return technologyService.getById(id);
    }
    
    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateTechnologyRequest createTechnologyRequest) throws ValidationException{
        this.technologyService.add(createTechnologyRequest);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.technologyService.delete(id);
    }
    
    @PutMapping()
    public void update(@RequestBody() UpdateTechnologyRequest updateTechnologyRequest) throws DataIntegrityViolationException{
        this.technologyService.update(updateTechnologyRequest);
    }
    
}
