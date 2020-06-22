package com.wander.userservice.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;

@ControllerAdvice
public class WebExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public String handleUserNotFoundException(Exception exception, WebRequest webRequest, Model model) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timeStamp(LocalTime.now())
                .message(exception.getLocalizedMessage())
                .details(webRequest.getDescription(false))
                .build();

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(value = {UserServiceCustomException.class})
    public String handleUserCustomeException(Exception exception, WebRequest webRequest, Model model) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timeStamp(LocalTime.now())
                .message(exception.getLocalizedMessage())
                .details(webRequest.getDescription(false))
                .build();

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    public String handleDataIntegrityException(WebRequest webRequest, Model model) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timeStamp(LocalTime.now())
                .message("Username/Email already exist.")
                .details(webRequest.getDescription(false))
                .build();

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }

    @ExceptionHandler(value = {Exception.class})
    public String handleAllException(Exception exception, WebRequest webRequest, Model model) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .timeStamp(LocalTime.now())
                .message(exception.getLocalizedMessage())
                .details(webRequest.getDescription(false))
                .build();

        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
}
