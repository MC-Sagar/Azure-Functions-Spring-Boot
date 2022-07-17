package com.ptai.nachpay.exceptions;

import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.ptai.nachpay.model.ResponseBuilder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// Doesn't work for some reason
public class CustomControllerAdvice {

    public CustomControllerAdvice() {
        System.out.println("@@@@@@@@@@ IN Customer controller advice @@@@@@@@");
    }

    @ExceptionHandler(NullPointerException.class) // exception handled
    public HttpResponseMessage handleNullPointerExceptions(NullPointerException e) {
        // ... potential custom logic
        System.out.println("IN Exception");
        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseBuilder().status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(status, e.getMessage())).build();
    }


    // fallback method
    @ExceptionHandler(Exception.class) // exception handled
    public HttpResponseMessage handleExceptions(Exception e) {
        // ... potential custom logic
        System.out.println("IN Exceptions");
        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseBuilder().status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(status, e.getMessage())).build();
    }

}
