package lk.ijse.experdia_car_rental_system.advisor;

import lk.ijse.experdia_car_rental_system.exception.NotFoundException;
import lk.ijse.experdia_car_rental_system.util.ResponceUtil;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice

public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ResponceUtil exceptionHandler(Exception e) {
        return new ResponceUtil(500, e.getMessage(), null);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponceUtil notFountException(Exception e){
        return new ResponceUtil(200,e.getMessage(),HttpStatus.NOT_FOUND);
    }

    public ResponceUtil validationException(Exception e){
        return new ResponceUtil(200,e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
