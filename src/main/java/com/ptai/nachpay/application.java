package com.ptai.nachpay;


import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.ptai.nachpay.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(application.class, args);
    }

//    @Bean
//    public Function<HttpRequestMessage<Optional<User>>, HttpResponseMessage> hello() {
//        System.out.println("@@@@@@@@@@ in spring boot @@@@@@@@@@");
//        return request -> request.createResponseBuilder(HttpStatus.OK).body("sd").build();
//    }
}
