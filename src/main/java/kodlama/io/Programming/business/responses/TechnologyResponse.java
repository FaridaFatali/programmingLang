package kodlama.io.Programming.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnologyResponse {
    private int id;
    private String name;
    private int language_id;
    private String language_name;
    
}
