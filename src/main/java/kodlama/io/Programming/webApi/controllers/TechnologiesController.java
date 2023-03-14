package kodlama.io.Programming.webApi.controllers;

import java.util.List;
import kodlama.io.Programming.business.abstracts.TechnologyService;
import kodlama.io.Programming.business.requests.TechnologyRequest;
import kodlama.io.Programming.business.responses.TechnologyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
    private TechnologyService technologyService;
    
    @Autowired
    public TechnologiesController(TechnologyService technologyService){
        this.technologyService = technologyService;
    }
    
    @GetMapping("/getall")
    public List<TechnologyResponse> getAll(){
        return technologyService.getAll();
    }
    
    @PostMapping("/add")
    public void add(@RequestBody TechnologyRequest technologyRequest) throws Exception{
        this.technologyService.add(technologyRequest);
    }
    
    @DeleteMapping("/delete")
    public void delete(int id){
        this.technologyService.delete(id);
    }
    
    @PutMapping("/update")
    public void update(int id, TechnologyRequest technologyRequest){
        this.technologyService.update(id, technologyRequest);
    }
    
    @GetMapping("/get")
    public TechnologyResponse getById(int id){
        return technologyService.getResponseById(id);
    }
    
}
