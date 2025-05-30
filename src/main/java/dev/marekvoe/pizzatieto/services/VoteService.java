package dev.marekvoe.pizzatieto.services;

import dev.marekvoe.pizzatieto.models.Pizza;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteService {

    private final Map<Integer, Integer> votes = new HashMap<>();
    private final TokenService tokenService;
    private final PizzaService pizzaService;

    public VoteService(TokenService tokenService, PizzaService pizzaService) {
        this.tokenService = tokenService;
        this.pizzaService = pizzaService;
    }

    public void voteForPizza(int pizzaId, String token) {
        if (!tokenService.isTokenValid(token)) {
            throw new IllegalArgumentException("Neplatný token. Nebo token byl již použit.");
        }
        votes.put(pizzaId, votes.getOrDefault(pizzaId, 0) + 1);

        pizzaService.getAllPizzas().stream()
                .filter(p -> p.getId() == pizzaId)
                .findFirst()
                .ifPresent(p -> p.setUpvotes(p.getUpvotes() + 1));

        tokenService.invalidateToken(token);
    }

    public void unvoteForPizza(int pizzaId, String token) {
        if (!tokenService.isTokenValid(token)) {
            throw new IllegalArgumentException("Neplatný token. Nebo token byl již použit.");
        }
        votes.put(pizzaId, Math.max(0, votes.getOrDefault(pizzaId, 0) - 1));

        pizzaService.getAllPizzas().stream()
                .filter(p -> p.getId() == pizzaId)
                .findFirst()
                .ifPresent(p -> p.setUpvotes(Math.max(0, p.getUpvotes() - 1)));

        tokenService.invalidateToken(token);
    }

    public Map<Integer, Integer> getVoteResults() {
        return new HashMap<>(votes);
    }
}