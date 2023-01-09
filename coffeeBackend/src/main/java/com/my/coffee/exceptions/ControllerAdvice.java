package com.my.coffee.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.my.coffee.entities.ApiResponse;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value=NotFoundExeception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
public  ApiResponse handleNotFoundException(NotFoundExeception exception, WebRequest request){
return new ApiResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage(),new Date(),request.getDescription(true));
}
@ExceptionHandler(value=Exception.class)
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public  ApiResponse handleNotFoundException(Exception exception, WebRequest request){
return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage(),new Date(),request.getDescription(true));
}
}
