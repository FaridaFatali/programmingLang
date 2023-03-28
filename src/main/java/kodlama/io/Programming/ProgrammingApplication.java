package kodlama.io.Programming;

import java.util.HashMap;
import kodlama.io.Programming.core.utilities.exceptions.BusinessException;
import kodlama.io.Programming.core.utilities.exceptions.ProblemDetails;
import kodlama.io.Programming.core.utilities.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class ProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingApplication.class, args);
	}
        
        @ExceptionHandler
        @ResponseStatus(code=HttpStatus.BAD_REQUEST)
        public ProblemDetails handleBusinessException(BusinessException businessException){
            ProblemDetails problemDetails = new ProblemDetails();
            problemDetails.setMessage(businessException.getMessage());
            
            return problemDetails;
        }
        
        @ExceptionHandler
        @ResponseStatus(code=HttpStatus.BAD_REQUEST)
        public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
            ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
            validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
            validationProblemDetails.setValidationErrors(new HashMap<String, String>());
            
            for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()){
                validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            
            return validationProblemDetails;
        }

        @Bean
        public ModelMapper getModelMApper(){
            return new ModelMapper();
        }
}
