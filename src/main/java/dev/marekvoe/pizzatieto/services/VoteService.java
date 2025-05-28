package dev.marekvoe.pizzatieto.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteService {

    private final Map<Integer, Integer> votes = new HashMap<>();
    private final TokenService tokenService;

    public VoteService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public void voteForPizza(int pizzaId, String token) {
        if (!tokenService.isTokenValid(token)) {
            throw new IllegalArgumentException("Neplatný token. Nebo token byl již použit.");
        }
        System.out.println("Vote Service Token: " + token);
        votes.put(pizzaId, votes.getOrDefault(pizzaId, 0) + 1);
        tokenService.invalidateToken(token);
    }

    public void unvoteForPizza(int pizzaId, String token) {
        if (!tokenService.isTokenValid(token)) {
            throw new IllegalArgumentException("Neplatný token. Nebo token byl již použit.");
        }
        System.out.println("Unvote Service Token: " + token);
        votes.put(pizzaId, Math.max(0, votes.getOrDefault(pizzaId, 0) - 1));
        tokenService.invalidateToken(token);
    }

    public Map<Integer, Integer> getVoteResults() {
        return new HashMap<>(votes);
    }
}