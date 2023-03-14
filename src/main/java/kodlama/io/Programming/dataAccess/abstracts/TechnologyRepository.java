package kodlama.io.Programming.dataAccess.abstracts;

import kodlama.io.Programming.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{
    Technology findById(int id);
    //Technology findByName(String name);
}
