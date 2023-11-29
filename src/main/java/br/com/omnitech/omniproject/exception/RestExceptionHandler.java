package br.com.omnitech.omniproject.exception;

import br.com.omnitech.omniproject.controller.dto.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {ProjetoException.class})
    protected ResponseEntity<Object> handleConflict(
            ProjetoException ex, WebRequest request) {
        return handleExceptionInternal(ex, new ApiResponse(ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
