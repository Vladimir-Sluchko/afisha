package by.itacademy.user.controller.advices;

import by.itacademy.user.service.dto.error.SingleError;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) ///400  ошибка
    public List<SingleError> handle(HttpMessageNotReadableException e){
        List<SingleError> errors = new ArrayList<>();
        errors.add(new SingleError(e.getMessage()));
        return errors;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) ///400  ошибка
    public List<SingleError> handle(MethodArgumentNotValidException e){
        List<SingleError> errors = new ArrayList<>();
        errors.add(new SingleError(e.getMessage()));
        return errors;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST) ///400  ошибка
    public List<SingleError> handle(EntityExistsException e){
        List<SingleError> errors = new ArrayList<>();
        errors.add(new SingleError(e.getMessage()));
        return errors;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN) ///400  ошибка
    public List<SingleError> handle(SecurityException e){
        List<SingleError> errors = new ArrayList<>();
        errors.add(new SingleError(e.getMessage()));
        return errors;
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR) //500 ошибка
    public List<Map<String,Object>> handle(IllegalStateException e){
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("logref","error");
        map.put("message",e.getMessage());
        data.add(map);
        return data;
    }

    /*@ExceptionHandler
    public List<Map<String,Object>> handle(Exception e){
        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("logref","error");
        map.put("message",e.getMessage());
        data.add(map);
        return data;
    }*/
}
