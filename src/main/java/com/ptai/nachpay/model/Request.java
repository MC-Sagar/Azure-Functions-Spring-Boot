package com.ptai.nachpay.model;

import com.microsoft.azure.functions.HttpRequestMessage;

import java.util.Optional;

public class Request<T> {
    private T t;
    HttpRequestMessage<Optional<T>> requestMessage;

    public Request(HttpRequestMessage<Optional<T>> requestMessage) {
        this.requestMessage = requestMessage;
    }

    public HttpRequestMessage<Optional<T>> getRequestMessage() {
        return requestMessage;
    }
}
