package com.binaryho.livestudyweek4mission.common;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> IOExceptionHandler(HttpServletRequest request, IOException exception) {

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(request.getRequestURL() + ", " + exception.getMessage());
    }
}
