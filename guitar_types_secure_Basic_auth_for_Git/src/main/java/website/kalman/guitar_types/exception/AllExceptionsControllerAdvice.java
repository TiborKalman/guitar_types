package website.kalman.guitar_types.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AllExceptionsControllerAdvice {

    @ExceptionHandler(HttpStatusDetailsException.class)
    public ResponseEntity<MyErrorMessage> handleException(HttpStatusDetailsException exc, WebRequest wr){

        MyErrorMessage myErrorMessage = new MyErrorMessage();
        myErrorMessage.setFullMessage(wr.getDescription(true));
        myErrorMessage.setMessage(exc.getMessage());

        return new ResponseEntity<>(myErrorMessage, HttpStatus.BAD_REQUEST);
    }
}