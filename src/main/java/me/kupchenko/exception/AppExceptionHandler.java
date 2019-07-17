package me.kupchenko.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({StudentNotFoundException.class, CourseNotFoundException.class})
    public ResponseEntity handleNotFound() {
        return ResponseEntity.notFound().build();
    }
}
