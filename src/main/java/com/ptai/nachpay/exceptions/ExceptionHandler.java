package com.ptai.nachpay.exceptions;

import com.google.firebase.auth.FirebaseAuthException;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.ptai.nachpay.model.ResponseBuilder;

public class ExceptionHandler {
    public static HttpResponseMessage handleNullTokenException(FirebaseNullTokenException exception) {
        return new ResponseBuilder()
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ExceptionResponse(HttpStatus.UNAUTHORIZED, exception.getMessage()))
                .build();
    }

    public static HttpResponseMessage handleUnauthorizedException(FirebaseAuthException exception) {
        return new ResponseBuilder()
                .status(HttpStatus.UNAUTHORIZED)
                .body(new ExceptionResponse(HttpStatus.UNAUTHORIZED, exception.getMessage()))
                .build();
    }
}
