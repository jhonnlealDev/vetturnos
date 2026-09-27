/*
 * Esta clase se encarga de la generacion, firma, extraccion de claims y validacion de tokens JWT para la seguridad del sistema.
 * Los datos provienen del UserDetails en la autenticacion y son procesados para validar las peticiones HTTP protegidas.
 */
package com.veterinaria.vetturno.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "VetTurnoSuperSecretKeyForJWTHuellitas2026!";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    public String generarToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(obtenerClaveFirma(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extraerEmail(String token) {
        return extraerClaim(token, claims -> claims.getSubject());
    }

    public <T> T extraerClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extraerTodosLosClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean esTokenValido(String token, UserDetails userDetails) {
        final String email = extraerEmail(token);
        return (email.equals(userDetails.getUsername())) && !estaExpirado(token);
    }

    private boolean estaExpirado(String token) {
        return extraerExpiracion(token).before(new Date());
    }

    private Date extraerExpiracion(String token) {
        return extraerClaim(token, claims -> claims.getExpiration());
    }

    private Claims extraerTodosLosClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(obtenerClaveFirma())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key obtenerClaveFirma() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
}
