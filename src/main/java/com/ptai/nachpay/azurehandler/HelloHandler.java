package com.ptai.nachpay.azurehandler;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.ptai.nachpay.model.User;
import com.ptai.nachpay.model.Request;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;


public class HelloHandler extends FunctionInvoker<Request<User>, HttpResponseMessage> {


    @FunctionName("hello")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        Request<User> customRequest = new Request<>(request);
        return handleRequest(customRequest, context);
    }
}
