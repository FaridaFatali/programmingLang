package kodlama.io.Programming.dataAccess.abstracts;

import kodlama.io.Programming.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
    boolean existsByName(String name);

//    Language findById(int id);
//    Language findByName(String name);
}
