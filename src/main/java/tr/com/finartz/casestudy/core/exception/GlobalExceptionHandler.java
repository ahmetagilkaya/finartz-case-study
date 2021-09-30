package tr.com.finartz.casestudy.core.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                new Date(),
                HttpStatus.BAD_REQUEST,
                Objects.requireNonNull(exception.getFieldError()).getDefaultMessage()
        );

        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ExceptionMessage> handleEntityNotFoundException(EntityNotFoundException exception){
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                new Date(),
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );

        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {TransactionSystemException.class})
    public ResponseEntity<ExceptionMessage> handleTransactionSystemException(TransactionSystemException exception){
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                new Date(),
                HttpStatus.NOT_FOUND,
                exception.getMessage()
        );

        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public ResponseEntity<ExceptionMessage> handleDataIntegrityViolationException(DataIntegrityViolationException exception){
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                new Date(),
                HttpStatus.BAD_REQUEST,
                exception.getMostSpecificCause().getMessage()
        );

        return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionMessage> handleException(Exception exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage()
        );

        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
