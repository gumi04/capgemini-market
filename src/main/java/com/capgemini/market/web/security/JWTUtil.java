package com.capgemini.market.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    private  static  final String KEY ="capgemini"; //compleja y cifrada solo con fines educativos

    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername()) //sesetea el usuario
                .setIssuedAt(new Date()) //feha de inicio
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10)) //lde damos 10 hrs de vida al token
                .signWith(SignatureAlgorithm.HS256,KEY).compact();
    }

    public boolean validateToken(String token,UserDetails userDetails){
        return  userDetails.getUsername().equals(extratUsername(token)) && !isTokenExpired(token);
    }

    public String extratUsername(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        return  getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
