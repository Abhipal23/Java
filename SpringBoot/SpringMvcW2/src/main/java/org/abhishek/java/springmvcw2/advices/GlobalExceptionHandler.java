package org.abhishek.java.springmvcw2.advices;

import org.abhishek.java.springmvcw2.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler( ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException e){

        ApiError apiError= ApiError.builder().status(HttpStatus.NOT_FOUND)
                .message(e.getMessage()).build();

        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception e){
       ApiError apiError= ApiError.builder()
               .status(HttpStatus.INTERNAL_SERVER_ERROR)
               .message(e.getMessage()).build();
       return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
       List<String> errors =e
               .getBindingResult()
               .getAllErrors()
               .stream()
               .map(error->error.getDefaultMessage())
               .toList();

       ApiError apiError = ApiError.builder()
               .status(HttpStatus.BAD_REQUEST)
               .message("Input Validation Failed")
               .subError(errors)
               .build();
       return  buildErrorResponseEntity(apiError);
    }
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
       return  new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatus());
    }

}
