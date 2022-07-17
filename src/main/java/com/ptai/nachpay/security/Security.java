package com.ptai.nachpay.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.ptai.nachpay.exceptions.FirebaseNullTokenException;
import com.ptai.nachpay.model.Request;
import com.ptai.nachpay.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class Security {

    @Autowired
    FirebaseAuth firebaseAuth;

    public FirebaseToken getVerifiedToken(Request<User> request) throws FirebaseAuthException, FirebaseNullTokenException {

        String bearerToken  = null;
        String authorizationHeader = request.getRequestMessage().getHeaders().get("authorization");
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            bearerToken = authorizationHeader.substring(7, authorizationHeader.length());
            return firebaseAuth.verifyIdToken(bearerToken);
        }
        throw new FirebaseNullTokenException("Missing Bearer Token");
    }

}
