package com.ptai.nachpay.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirebaseNullTokenException extends Throwable {

    private String message;

    public FirebaseNullTokenException() {}
    public FirebaseNullTokenException(String message) {
        super(message);
        this.message = message;
    }
}
