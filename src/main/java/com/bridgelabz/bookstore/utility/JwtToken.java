package com.bridgelabz.bookstore.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Component;

@Component
public class JwtToken {
    private static final String TOKEN_SECRET = "SecretKey";

    public String createToken(Long id){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            String token = JWT.create().withClaim("id",id).sign(algorithm);
            return token;
        } catch (JWTCreationException jwtCreationException){
            jwtCreationException.printStackTrace();
        } catch (IllegalArgumentException argumentException){
            argumentException.printStackTrace();
        }
        return null;
    }
}
