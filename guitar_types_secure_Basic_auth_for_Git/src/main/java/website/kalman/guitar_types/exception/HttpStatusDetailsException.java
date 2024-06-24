package website.kalman.guitar_types.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class HttpStatusDetailsException extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;
}
