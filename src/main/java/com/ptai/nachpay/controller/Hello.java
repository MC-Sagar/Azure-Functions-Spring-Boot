package com.ptai.nachpay.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.ptai.nachpay.repositories.Todo;
import com.ptai.nachpay.repositories.TodoRepository;
import com.ptai.nachpay.exceptions.ExceptionHandler;
import com.ptai.nachpay.exceptions.FirebaseNullTokenException;
import com.ptai.nachpay.model.Request;
import com.ptai.nachpay.model.ResponseBuilder;
import com.ptai.nachpay.model.User;
import com.ptai.nachpay.security.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Hello implements Function<Request<User>, HttpResponseMessage> {

    @Autowired
    Security security;

    @Autowired
    private TodoRepository todoRepository;


    public HttpResponseMessage apply(Request<User> request) {
        try {
            FirebaseToken verifiedToken = security.getVerifiedToken(request);
        } catch (FirebaseNullTokenException exception) {
            return ExceptionHandler.handleNullTokenException(exception);
        } catch (FirebaseAuthException exception) {
            return ExceptionHandler.handleUnauthorizedException(exception);
        }
        // If you want to fetch request body or headers
        User user = request.getRequestMessage().getBody().get();

        // Example DB operation
        Todo todo = todoRepository.save(new Todo("coding"));
        System.out.println(todo.getId());

        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .body(todoRepository.save(new Todo("sleeping")))
                .build();
    }
}