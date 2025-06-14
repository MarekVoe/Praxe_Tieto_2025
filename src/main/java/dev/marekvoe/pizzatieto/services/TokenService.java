package dev.marekvoe.pizzatieto.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class TokenService {

    private final Set<String> validTokens = new HashSet<>();

    public String generateToken() {
        String token = UUID.randomUUID().toString();
        validTokens.add(token);
        return token;
    }

    public boolean isTokenValid(String token) {
        return validTokens.contains(token);
    }

    public void invalidateToken(String token) {
        validTokens.remove(token);
    }
}