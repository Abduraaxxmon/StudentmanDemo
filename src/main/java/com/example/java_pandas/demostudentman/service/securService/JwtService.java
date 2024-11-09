package com.example.java_pandas.demostudentman.service.securService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
public class JwtService {
    private static final String SECRET_KEY ="921cfb3e60c3f57063634af29f30d41ff460c211d91ae2dbe61d2f38b7c932b77e271ce0b29ccfefcce5bb6b4ef92704206dbd889c61a6db925b66de961e97f3a6cf688a4170d56e761f547ba30062a8d6175ae40040362ad9036aff0965ddd06c87efd243399d7c61d6d7fd1017103c95bc3607f61cccb10a8ed4ee351438ba4916a8dd3a5324f6f674990fd65b60c06013f41b858d62bae588a9676241ec1bb35015d90f449d85021de7389223d2f1fb46476a19c04aa7be1faf95910ff53a71a5c98c6402adb54f888689ccfbdafc4d78271e2e432a872e5c1c4077a99723";

    public String generateToken(String email){
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*1000))
                .and()
                .signWith(getKey())
                .compact();
    }
    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(SECRET_KEY));
    }
    public String extractEmail(String token){
        return extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }
    public Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractEmail(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }
}
