package com.du.javaCourse.resources.exceptions;

import com.du.javaCourse.services.exceptions.DatabaseException;
import com.du.javaCourse.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest req) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError();
        err.setError("Resource not found");
        err.setStatus(status.value());
        err.setTimestamp(Instant.now());
        err.setMessage(e.getMessage());
        err.setPath(req.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest req) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError();
        err.setError("Database error");
        err.setStatus(status.value());
        err.setTimestamp(Instant.now());
        err.setMessage(e.getMessage());
        err.setPath(req.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

}
