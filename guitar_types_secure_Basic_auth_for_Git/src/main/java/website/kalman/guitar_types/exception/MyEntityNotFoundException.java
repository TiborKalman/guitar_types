package website.kalman.guitar_types.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyEntityNotFoundException extends RuntimeException{

    public MyEntityNotFoundException(String s) {
        super(s);
    }

}
