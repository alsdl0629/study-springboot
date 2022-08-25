package com.example.login.global.security.jwt;

import com.example.login.damain.refreshtoken.RefreshRepository;
import com.example.login.damain.refreshtoken.RefreshToken;
import com.example.login.damain.user.presentation.dto.response.TokenResponse;
import com.example.login.global.exception.ExpiredTokenException;
import com.example.login.global.exception.InvalidTokenException;
import com.example.login.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;
    private final RefreshRepository refreshRepository;

    public TokenResponse generateToken(String email) {
        String accessToken = generateAccessToken(email);
        String refreshToken = generateRefreshToken(email);

        refreshRepository.save(RefreshToken.builder()
                .userEmail(email)
                .refreshToken(refreshToken)
                .ttl(jwtProperties.getRefreshExp())
                .build());

        return new TokenResponse(accessToken, refreshToken);
    }

    public String generateAccessToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .claim("type", "access")
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExp() * 1000))
                .setIssuedAt(new Date())
                .compact();
    }

    public String generateRefreshToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .claim("type", "refresh")
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExp() * 1000))
                .setIssuedAt(new Date())
                .compact();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if(bearerToken != null && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > 7) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getTokenSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public boolean isRefresh(String token) {
        return getBody(token).get("type").equals("refresh");
    }

    private Claims getBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (MalformedJwtException | SignatureException e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    private String getTokenSubject(String token) {
        return getBody(token).getSubject();
    }

}
